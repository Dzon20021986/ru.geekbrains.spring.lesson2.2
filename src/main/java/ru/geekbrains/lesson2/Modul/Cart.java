package ru.geekbrains.lesson2.Modul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.lesson2.Service.ProductRepositoryService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
@Scope("prototype")
public class Cart {

    private ProductRepositoryService productService;
    private List<Product> productList;

    @Autowired
    public void setProductService(ProductRepositoryService productService) {
        this.productService = productService;
    }

    public List<Product> getAllProduct() {
        return productList;
    }

    @PostConstruct
    private void init() {
        productList = new ArrayList<>();
    }

//    public void addProduct(long id){
//        productList.add(productService.getProduct(id));
//    }

    public void deleteProduct(long id){
        productList.removeIf(p ->p.getId().equals(id));
    }
}
