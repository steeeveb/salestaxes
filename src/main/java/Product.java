package src.main.java;

import java.math.BigDecimal;
import java.util.*;
import src.main.java.salestaxes.*;


public class Product implements TaxableItem{
    private BigDecimal price;
    private String name;
    private final boolean imported;

    public Product(String name, BigDecimal price, boolean imported){
        this.price = price;
        this.name = name;
        this.imported = imported;
    }

    public BigDecimal total(Set<TaxRule> rules){
        return price.add(salesTaxes(rules));
    }

    public BigDecimal salesTaxes(Set<TaxRule> rules){
        BigDecimal result = new BigDecimal(0);
        for (TaxRule rule : rules){
            result = result.add(rule.compute(price));
        }
        return result;
    }

    public String name(){
        return name;
    }

    public boolean imported(){
        return imported;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Product other = (Product) obj;
        return
            name.equals(other.name) &&
            price.equals(other.price) &&
            imported == other.imported;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + price.hashCode();
        return result;
    }
}
