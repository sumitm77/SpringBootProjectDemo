package com.springBootProject.sumit.entities;

import org.springframework.stereotype.Service;

//@Component -- We can use @Component or @Service as well
@Service
public class Product {

    private String name;
    private int id;
    private double price;
    private String about;

    public Product() {
    }

    public Product(String name, int id, double price, String about) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.about = about;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", about='" + about + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
