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
            body += String.format("%s: %.2f\n", product.description(), product.total());
        };
        return body;
    }
}

