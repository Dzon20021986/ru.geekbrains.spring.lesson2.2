package ru.geekbrains.lesson2.repository;

import ru.geekbrains.lesson2.Modul.Product;

import java.util.List;

public interface CartRepository {

    void addProduct(Long id);

    void deleteProduct(Long id);

    List<Product> productList();

    List<Product> getAllProduct();
}
