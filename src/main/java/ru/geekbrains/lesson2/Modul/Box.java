package ru.geekbrains.lesson2.Modul;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Box {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Box(String color) {
        this.color = color;
    }

    @PostConstruct
    public void init() {
        color = "RED";
    }

    public Box() {

    }
}
