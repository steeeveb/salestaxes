package src.main.java;

import java.util.*;

import java.math.BigDecimal;
import src.main.java.salestaxes.*;


public class ProductRepository implements Repository{
    private List<Match> taxMatches = new ArrayList<>();

    public ProductRepository(){
        Tax tax = new Tax();
        taxMatches.add(new DescriptionMatch(tax.exemption(), tax.basic(), "book", "chocolate", "pills"));
        taxMatches.add(new DescriptionMatch(tax.duty(), tax.dutyFree(), "imported"));
    }

    public Sellable get(String line) throws ProductNotFound{
        InputLine parsedLine = InputLine.parse(line);
        if (parsedLine == null){
            throw new ProductNotFound();
        }
        Set<TaxRule> rules = getRules(parsedLine.description);

        return new Product(parsedLine.description, parsedLine.price,
                           rules.toArray(new TaxRule[rules.size()]));
    }
    private Set<TaxRule> getRules(String description){
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
