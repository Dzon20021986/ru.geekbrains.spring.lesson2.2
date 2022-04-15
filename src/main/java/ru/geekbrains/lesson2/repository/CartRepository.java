package ru.geekbrains.lesson2.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.lesson2.Modul.Product;

import java.util.List;

@Component
public interface CartRepository {

    void addProduct(Long id);

    void deleteProduct(Long id);

    List<Product> productList();

    List<Product> getAllProduct();
}
