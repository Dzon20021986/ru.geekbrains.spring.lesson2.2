package ru.geekbrains.lesson2.HW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Component
//@Primary
public class ProductInMemoryRepository implements Repository {

//    private List<Product> productList;
//
//    @PostConstruct
//    public void init() {
//        productList = new ArrayList<>(Arrays.asList(
//                new Product("Milk", 1L, 10),
//                new Product("Bread", 2L, 15),
//                new Product("Apple", 3L, 20),
//                new Product("Orange", 4L, 2),
//                new Product("Banana", 5L, 4),
//                new Product("Dumplings", 6L, 6),
//                new Product("Сheese", 7L, 9)
//
//        ));
//    }
//
//    @Override
//    public Product findById(Long id){
//        return productList.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
//    }
}
