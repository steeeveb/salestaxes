package src.main.java;

import java.util.*;

import java.math.BigDecimal;


public class ProductBuilder{
    private String name = "";
    private BigDecimal price = new BigDecimal(0);
    private boolean imported = false;

    public ProductBuilder called(String name){
        this.name = name;
        return this;
    }
    public ProductBuilder priced(BigDecimal price){
        this.price = price;
        return this;
    }
    public ProductBuilder priced(String price){
        this.price = new BigDecimal(price);
        return this;
    }
    public ProductBuilder imported(){
        this.imported = true;
        return this;
    }
    public Product build(){
        return new Product(name, price, imported);
    }
}
