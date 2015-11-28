package src.main.java;


import java.util.*;
import src.main.java.salestaxes.*;

public class TaxOffice implements TaxRepository {
    private TaxFactory tax = new TaxFactory();
    private String[] exemptions = {"book", "chocolate", "pills"};

    public Set<TaxRule> taxesFor(Sellable product){
        Set<TaxRule> rules = new HashSet<>();
        if (isNotExempt(product)){
            rules.add(tax.basic());
        }
        if (product.imported()){
            rules.add(tax.duty());
        } 
        return rules;
    }

    private boolean isNotExempt(Sellable product){
        return !isExempt(product);
    }
    private boolean isExempt(Sellable product){
        for (String key: exemptions){
            if (product.description().contains(key)){
                return true;
            };
        }
        return false;
    }
}
