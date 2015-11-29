package src.main.java.salestaxes;
import java.math.BigDecimal;
import java.util.*;

public interface TaxableItem{
    public BigDecimal total(List<TaxRule> rules);
    public BigDecimal salesTaxes(List<TaxRule> rules);
    public String name();
    public boolean imported();
}
