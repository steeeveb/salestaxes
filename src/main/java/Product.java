package src.main.java;

import java.math.BigDecimal;
import java.util.*;
import src.main.java.salestaxes.*;


public class Product implements Sellable{
    private BigDecimal price;
    private String description;
    private Set<TaxRule> rules;

    public Product(String description, BigDecimal price, TaxRule... rules){
        this.price = price;
        this.description = description;
        this.rules = new HashSet<>(Arrays.asList(rules));
    }

    public BigDecimal total(){
        return price.add(salesTaxes());
    }

    public BigDecimal salesTaxes(){
        BigDecimal result = new BigDecimal(0);
        for (TaxRule rule : rules){
            result = result.add(rule.compute(price));
        }
        return result;
    }

    public String description(){
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Product other = (Product) obj;
        return
            description.equals(other.description) &&
            price.equals(other.price) &&
            rules.equals(other.rules);
    }
}
