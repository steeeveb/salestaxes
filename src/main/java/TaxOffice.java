package src.main.java;


import java.util.*;
import src.main.java.salestaxes.*;

public class TaxOffice implements TaxRepository {
    private TaxFactory tax = new TaxFactory();
    private String[] exemptions = {"book", "chocolate", "pills"};

    public Set<TaxRule> taxesFor(TaxableItem product){
        Set<TaxRule> rules = new HashSet<>();
        if (isNotExempt(product)){
            rules.add(tax.basic());
        }
        if (product.imported()){
            rules.add(tax.duty());
        } 
        return rules;
    }

    private boolean isNotExempt(TaxableItem product){
        return !isExempt(product);
    }
    private boolean isExempt(TaxableItem product){
        for (String key: exemptions){
            if (product.name().contains(key)){
                return true;
            };
        }
        return false;
    }
}
