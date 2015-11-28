package src.main.java;


import java.util.*;
import src.main.java.salestaxes.*;

public class TaxOffice implements TaxRepository {
    private List<Match> taxMatches = new ArrayList<>();

    public TaxOffice(){
        Tax tax = new Tax();
        taxMatches.add(new DescriptionMatch(tax.exemption(), tax.basic(), "book", "chocolate", "pills"));
        taxMatches.add(new DescriptionMatch(tax.duty(), tax.dutyFree(), "imported"));
    }

    public Set<TaxRule> taxesFor(String description){
        Set<TaxRule> rules = new HashSet<>();
        for (Match match: taxMatches){
            rules.add(match.assignRule(description));
        }
        return rules;
    }
}


interface Match {
    public TaxRule assignRule(String description);
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

    public TaxRule assignRule(String description){
        if (test(description)) return rule;
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
