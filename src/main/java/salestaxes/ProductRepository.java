package src.main.java.salestaxes;

import java.math.BigDecimal;


public interface ProductRepository{
    public Sellable get(String line) throws ProductNotFound;
}
