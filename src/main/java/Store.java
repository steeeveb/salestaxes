package src.main.java;

import java.util.*;

import java.math.BigDecimal;
import src.main.java.salestaxes.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Store implements ProductRepository{
    String expression =
        "^([0-9]+) (?<description>.*?) " +
        "at (?<price>[0-9]+\\.[0-9][0-9]).*$";

    public TaxableItem get(String line) throws ProductNotFound{
        Matcher parsedLine = parse(line);

        return new Product(name(parsedLine),
                           price(parsedLine),
                           imported(parsedLine));
    }

    private String name(Matcher parsedLine){
        return parsedLine.group("description").replace("imported ", "").trim();
    }

    private BigDecimal price(Matcher parsedLine){
        return new BigDecimal(parsedLine.group("price"));
    }

    private boolean imported(Matcher parsedLine){
        return parsedLine.group("description").contains("imported ");
    }

    private Matcher parse(String line) throws ProductNotFound{
        Pattern pattern = Pattern.compile(expression);

        Matcher m = pattern.matcher(line);
        if (m.find()) {
            return m;
        }
        throw new ProductNotFound();
    }
}
