package src.main.java.salestaxes;


import java.util.*;
import java.math.*;

import src.main.java.TaxOffice;

public class Application {
    private TaxRepository taxRepository;
    private ProductRepository productRepository;
    private Display display;

    public Application(ProductRepository productRepository,
                       TaxRepository taxRepository,
                       Display display){
        this.productRepository = productRepository;
        this.taxRepository = taxRepository;
        this.display = display;
    }

    public String receipt(String input){
        List<Sellable> products = new ArrayList<>();
        String[] lines = input.split("\n");
        for (String line : lines){
            try {
                Sellable product = productRepository.get(line);
                Set<TaxRule> taxes = taxRepository.taxesFor(product);
                products.add(product.setTaxes(taxes));
            } catch (ProductNotFound e){}
        };

        return new Receipt(products).format(display);
    }
}
