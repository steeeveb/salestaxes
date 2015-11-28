package src.main.java;

import java.util.*;

import java.math.BigDecimal;
import src.main.java.salestaxes.*;


public class Store implements ProductRepository{
    public Sellable get(String line) throws ProductNotFound{
        InputLine parsedLine = InputLine.parse(line);
        if (parsedLine == null){
            throw new ProductNotFound();
        }
        return new Product(parsedLine.description, parsedLine.price);
    }
}
