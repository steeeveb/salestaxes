package src.main.java.salestaxes;


import java.util.*;
import java.math.*;


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

    public String receipt(Basket basket){
        Receipt receipt = new Receipt();
        for (String line : basket.lines()){
            TaxableItem product;
            try {
                product = productRepository.get(line);
            } catch (ProductNotFound e){
                continue;
            }
            List<TaxRule> taxes = taxRepository.taxesFor(product);
            receipt.add(product, taxes);
        };

        return receipt.print(display);
    }
}
