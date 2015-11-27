package src.main.java.salestaxes;
import java.math.*;
import java.util.*;


public class Receipt{
    private List<Sellable> products;

    public Receipt(List<Sellable> products){
        this.products = products;
    }

    public BigDecimal salesTaxes(){
        BigDecimal result = new BigDecimal(0);
        for (Sellable product: products){
            result = result.add(product.salesTaxes());
        }
        return result;
    }

    public BigDecimal total(){
        BigDecimal result = new BigDecimal(0);
        for (Sellable product: products){
            result = result.add(product.total());
        }
        return result;
    }

    public String format(Display display){
        return display.format(this, products);
    }
}
