package ru.geekbrains.lesson2.Сonfig;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.geekbrains.lesson2.Service.ProductRepositoryService;
import ru.geekbrains.lesson2.Service.CartRepositoryService;
import ru.geekbrains.lesson2.repository.CartRepository;
import ru.geekbrains.lesson2.repository.ProductRepository;


@Configuration
@ComponentScan("ru.geekbrains.lesson2")
public class AppConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ProductRepository productRepositoryService() {
        return new ProductRepositoryService();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CartRepository cartRepositoryService() {
        return new CartRepositoryService();
    }

}
