package src.main.java;

import java.math.BigDecimal;
import java.util.*;
import src.main.java.salestaxes.*;


public class Product implements TaxableItem{
    private BigDecimal price;
    private String description;
    private Set<TaxRule> rules;

    public Product(String description, String price, TaxRule... rules){
        this.price = new BigDecimal(price);
        this.description = description;
        this.rules = new HashSet<>(Arrays.asList(rules));
    }
    public Product(String description, BigDecimal price, TaxRule... rules){
        this.price = price;
        this.description = description;
        this.rules = new HashSet<>(Arrays.asList(rules));
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
        return description.replace("imported ", "").trim();
    }

    public boolean imported(){
        return description.contains("imported");
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + description.hashCode();
        result = prime * result + price.hashCode();
        result = prime * result + rules.hashCode();
        return result;
    }
}
