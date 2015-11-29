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
        String[] lines = input.split("\n");
        Receipt receipt = new Receipt();
        for (String line : lines){
            TaxableItem product;
            try {
                product = productRepository.get(line);
            } catch (ProductNotFound e){
                continue;
            }
            Set<TaxRule> taxes = taxRepository.taxesFor(product);
            receipt.add(product, taxes);
        };

        return receipt.print(display);
    }
}
