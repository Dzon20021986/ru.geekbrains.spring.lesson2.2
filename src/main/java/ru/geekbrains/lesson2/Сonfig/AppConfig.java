package ru.geekbrains.lesson2.Сonfig;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.geekbrains.lesson2.Service.ProductService;
import ru.geekbrains.lesson2.Service.ServiceCart;
import ru.geekbrains.lesson2.repository.CartRepository;
import ru.geekbrains.lesson2.repository.ProductRepository;


@Configuration
@ComponentScan("ru.geekbrains.lesson2")
public class AppConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ProductRepository productRepository() {
        return new ProductService();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CartRepository cartRepository() {
        return new ServiceCart();
    }

}
