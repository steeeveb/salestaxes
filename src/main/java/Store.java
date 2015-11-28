package src.main.java;

import java.util.*;

import java.math.BigDecimal;
import src.main.java.salestaxes.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Store implements ProductRepository{
    public Sellable get(String line) throws ProductNotFound{
        Matcher parsedLine = parse(line);
        if (parsedLine == null){
            throw new ProductNotFound();
        }
        return new Product(parsedLine.group("description"),
                           new BigDecimal(parsedLine.group("price")));
    }

    private Matcher parse(String line){
        String expression = "^(?<description>.*) at (?<price>[0-9]+\\.[0-9][0-9]).*$";
        Pattern pattern = Pattern.compile(expression);

        Matcher m = pattern.matcher(line);
        if (m.find( )) {
            return m;
        } else {
            return null;
        }
    }
}
