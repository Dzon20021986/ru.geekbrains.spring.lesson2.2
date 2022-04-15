package ru.geekbrains.lesson2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.lesson2.Modul.Product;
import ru.geekbrains.lesson2.repository.CartRepository;
import ru.geekbrains.lesson2.Сonfig.AppConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Client {
    private ApplicationContext context;
    private CartRepository cart;
    private String console;
    private BufferedReader reader;


    public Client() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("context setup: " + context.getApplicationName());

        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void startClient() {
        System.out.println("Для отображения команд введите -help");
        try {
            console = reader.readLine();
            while (!console.equals("-end")) {
                switch (console) {
                    case "-add":
                        addProduct();
                        break;
                    case "-delete":
                        removeProduct();
                        break;
                    case "-showCart":
                        showCart();
                        break;
                    case "-create":
                        createdCart();
                        break;
                    case "-help":
                        showHelp();
                        break;
                }
                console = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createdCart() {
        cart = context.getBean("CartRepository", CartRepository.class);
        System.out.println("Успешно создали новую корзину");
        showCart();
    }

    private void showCart() {
        if (cart == null) {
            System.out.println("Корзина не создана");
            return;
        }
        if (cart.getAllProduct().size() == 0) {
            System.out.println("Корзина пустая");
        } else {
            System.out.println("В корзине: ");
            for (Product p : cart.getAllProduct()) {
                System.out.println(p);
            }
        }
    }

    private void showHelp() {
        System.out.println("Для вызова списка команд введите -help \n\r" +
                "Для инициализации новой корзины товаров введите -create \n\r" +
                "Для получения списка товаров в корзине введите -showCart \n\r" +
                "Для добавления товара в корзину введите -add \n\r" +
                "Для удаления товара из корзины введите -delete \n\r" +
                "Для выхода введите -end \n\r");
    }

    private void removeProduct() {
        System.out.println("Введите ID товара для удаления из корзины: ");
        try {
            long id = Long.parseLong(reader.readLine());
            cart.deleteProduct(id);
            showCart();
        } catch (NumberFormatException | IOException e) {
            System.out.println("Ошибка! Заданный ID не существует");
        }
    }

    private void addProduct() {
        System.out.println("Введите ID товара: ");
        try {
            long id = Long.parseLong(reader.readLine());
            cart.addProduct(id);
            showCart();
        } catch (NumberFormatException | IOException e) {
            System.out.println("Ошибка! Заданный ID не существует");
        } catch (NullPointerException n) {
            System.out.println("Ошибка! Создайте корзину");
        }
    }

}
