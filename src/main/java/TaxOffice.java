package src.main.java;


import java.util.*;
import src.main.java.salestaxes.*;

public class TaxOffice implements TaxRepository {
    private List<Match> taxMatches = new ArrayList<>();

    public TaxOffice(){
        Tax tax = new Tax();
        taxMatches.add(new DescriptionMatch(tax.exemption(), tax.basic(), "book", "chocolate", "pills"));
        taxMatches.add(new ImportedMatch(tax.duty(), tax.dutyFree()));
    }

    public Set<TaxRule> taxesFor(Sellable product){
        Set<TaxRule> rules = new HashSet<>();
        for (Match match: taxMatches){
            rules.add(match.assignRule(product));
        }
        return rules;
    }
}


interface Match {
    public TaxRule assignRule(Sellable product);
}


class DescriptionMatch implements Match{
    String[] keys;
    TaxRule rule;
    TaxRule otherwise;

    public DescriptionMatch(TaxRule rule, TaxRule otherwise, String... keys){
        this.keys = keys;
        this.rule = rule;
        this.otherwise = otherwise;
    }

    public TaxRule assignRule(Sellable product){
        if (test(product.description())) return rule;
        return otherwise;
    }

    private boolean test(String description){
        for (String key: keys){
            if (description.contains(key)){
                return true;
            };
        }
        return false;
    }
}


class ImportedMatch implements Match{
    TaxRule rule;
    TaxRule otherwise;

    public ImportedMatch (TaxRule rule, TaxRule otherwise){
        this.rule = rule;
        this.otherwise = otherwise;
    }

    public TaxRule assignRule(Sellable product){
        if (product.imported()) return rule;
        return otherwise;
    }
}
