package ru.geekbrains.lesson2.Modul;

public class Product {
    private  Long id;
    private String title;
    private int cost;

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Product( Long id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }
}
