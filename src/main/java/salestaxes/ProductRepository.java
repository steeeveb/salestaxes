package src.main.java.salestaxes;

import java.math.BigDecimal;


public interface ProductRepository{
    public TaxableItem get(String line) throws ProductNotFound;
}
