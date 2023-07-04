package com.exercise.mode.factory;

import java.time.LocalDate;

/**
 * @ClassName Product
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/9/12 09:27
 * @Version 1.0
 **/
public abstract class Product {

    private String name;

    private LocalDate localDate;

    private float price;

    public Product(String name, LocalDate localDate, float price) {
        this.name = name;
        this.localDate = localDate;
        this.price = price;
    }
}
