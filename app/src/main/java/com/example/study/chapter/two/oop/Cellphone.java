package com.example.study.chapter.two.oop;

import java.util.Objects;

public class Cellphone {

    String brand;
    double price;

    public Cellphone(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cellphone cellphone = (Cellphone) o;
        return ((Cellphone) o).brand.equals(brand) && ((Cellphone) o).price == price;
    }

    @Override
    public int hashCode() {
        // brand.hashCode()  == Objects.hashCode(brand)
        return Objects.hashCode(brand) + (int) price;
    }
}
