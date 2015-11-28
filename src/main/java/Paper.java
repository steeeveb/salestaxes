package src.main.java;


import java.util.*;
import src.main.java.salestaxes.*;


public class Paper implements Display{
    public String format(Receipt receipt, List<Sellable> products){
        return body(products) + footer(receipt);
    }

    private String footer(Receipt receipt){
        String footer = String.format(
            "Sales Taxes: %.2f\nTotal: %.2f",
            receipt.salesTaxes(), receipt.total()
        );
        return footer;
    }

    private String body(List<Sellable> products){
        String body = "";
        for (Sellable product: products){
            body += line(product) + "\n";
        };
        return body;
    }

    private String line(Sellable product){
        String result = "1 ";
        if (product.imported()){
            result += "imported ";
        }
        result += String.format("%s: %.2f", product.description(), product.total());
        return result;
    }
}
