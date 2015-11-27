package src.main.java.salestaxes;

import java.math.BigDecimal;


public interface Repository{
    public Sellable get(String line) throws ProductNotFound;
}
