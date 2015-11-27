package src.main.java.salestaxes;
import java.math.BigDecimal;

public interface Sellable{
    public BigDecimal total();
    public BigDecimal salesTaxes();
    public String description();
}
