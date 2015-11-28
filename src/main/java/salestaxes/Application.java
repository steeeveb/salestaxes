package src.main.java.salestaxes;


import java.util.*;
import java.math.*;


public class Application {
    private ProductRepository repository;
    private Display display;

    public Application(ProductRepository repository, Display display){
        this.repository = repository;
        this.display = display;
    }

    public String receipt(String input){
        List<Sellable> products = new ArrayList<>();
        String[] lines = input.split("\n");
        for (String line : lines){
            try {
                products.add(repository.get(line));
            } catch (ProductNotFound e){}
        };

        return new Receipt(products).format(display);
    }
}
