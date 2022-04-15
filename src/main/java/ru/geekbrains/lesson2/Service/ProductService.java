package ru.geekbrains.lesson2.Service;


import org.springframework.stereotype.Component;
import ru.geekbrains.lesson2.repository.ProductRepository;
import ru.geekbrains.lesson2.Modul.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductService implements ProductRepository {

    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1L, "Milk", 10),
                new Product(2L, "Bread", 15),
                new Product(3L, "Apple", 17),
                new Product(4L, "Orange", 3),
                new Product(5L, "Banana", 4)
        ));
    }

    @Override
    public Product findById(Long id) {
        return productList.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

    @Override
    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productList.removeIf(p -> p.getId().equals(id));

    }

    @Override
    public List<Product> productList() {
        return productList;
    }






//    @Autowired
//    private  Box box;
//
//    @Autowired
//    private FileOutputStream fileOutputStream;
//
//    public Box getBox() {
//        return box;
//    }
//
//    public void createProduct() {
//        try {
//            fileOutputStream.write("READY".getBytes());
//            fileOutputStream.close();
//            System.out.println("Продукт создан");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
