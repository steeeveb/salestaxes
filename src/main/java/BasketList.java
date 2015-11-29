package src.main.java;

import src.main.java.salestaxes.*;


public class BasketList implements Basket {
    private String input;
    public BasketList(String input){
        this.input = input;
    }
    public String[] lines(){
        return input.split("\n");
    }
}

