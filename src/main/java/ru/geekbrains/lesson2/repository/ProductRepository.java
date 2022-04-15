package ru.geekbrains.lesson2.repository;


import org.springframework.stereotype.Component;
import ru.geekbrains.lesson2.Modul.Product;

import java.util.List;

@Component
public interface ProductRepository {
    Product findById(Long id);

    void addProduct(Product product);

    void deleteProduct(Long id);

    List<Product> productList();


}
