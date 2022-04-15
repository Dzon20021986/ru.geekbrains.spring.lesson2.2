package ru.geekbrains.lesson2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.lesson2.Modul.Product;
import ru.geekbrains.lesson2.repository.CartRepository;
import ru.geekbrains.lesson2.repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class CartRepositoryService implements CartRepository {

    private List<Product> cart;

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        cart = new ArrayList<>();
    }

    @Override
    public void addProduct(Long id) {
        cart.add(productRepository.findById(id));
    }

    @Override
    public void deleteProduct(Long id) {
        cart.removeIf(p -> p.getId().equals(id));

    }

    @Override
    public List<Product> productList() {
        return cart;
    }

    public List<Product> getAllProduct() {
        return cart;
    }

}
