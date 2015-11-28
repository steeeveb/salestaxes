package src.main.java;

import java.util.*;

import java.math.BigDecimal;
import src.main.java.salestaxes.*;


public class Store implements ProductRepository{
    private TaxRepository taxRepository = new TaxOffice();

    public Sellable get(String line) throws ProductNotFound{
        InputLine parsedLine = InputLine.parse(line);
        if (parsedLine == null){
            throw new ProductNotFound();
        }
        Set<TaxRule> rules = taxRepository.taxesFor(parsedLine.description);

        return new Product(parsedLine.description, parsedLine.price,
                           rules.toArray(new TaxRule[rules.size()]));
    }
}
