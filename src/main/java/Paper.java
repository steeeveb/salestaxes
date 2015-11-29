package src.main.java;


import java.util.*;
import java.math.*;
import src.main.java.salestaxes.*;


public class Paper implements Display{
    private List<String> lines = new ArrayList<>();

    public String print(BigDecimal salesTaxes, BigDecimal total){
        return body() + footer(salesTaxes, total);
    }

    private String footer(BigDecimal salesTaxes, BigDecimal total){
        String footer = String.format(
            "Sales Taxes: %.2f\nTotal: %.2f", salesTaxes, total
        );
        return footer;
    }

    private String body(){
        String result = "";
        for ( String line: lines){
            result += line + "\n";
        };
        return result;
    }

    public void addLine(TaxableItem product, BigDecimal total){
        String result = "1 ";
        if (product.imported()){
            result += "imported ";
        }
        result += String.format("%s: %.2f", product.name(), total);
        lines.add(result);
    }
}
