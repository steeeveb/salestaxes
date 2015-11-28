package src.main.java;


import java.util.*;
import src.main.java.salestaxes.*;


public class Paper implements Display{
    public String format(Receipt receipt, List<TaxableItem> products){
        return body(products) + footer(receipt);
    }

    private String footer(Receipt receipt){
        String footer = String.format(
            "Sales Taxes: %.2f\nTotal: %.2f",
            receipt.salesTaxes(), receipt.total()
        );
        return footer;
    }

    private String body(List<TaxableItem> products){
        String body = "";
        for (TaxableItem product: products){
            body += line(product) + "\n";
        };
        return body;
    }

    private String line(TaxableItem product){
        String result = "1 ";
        if (product.imported()){
            result += "imported ";
        }
        result += String.format("%s: %.2f", product.name(), product.total());
        return result;
    }
}
