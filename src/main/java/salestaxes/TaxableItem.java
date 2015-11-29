package src.main.java.salestaxes;
import java.math.BigDecimal;
import java.util.Set;

public interface TaxableItem{
    public BigDecimal total(Set<TaxRule> rules);
    public BigDecimal salesTaxes(Set<TaxRule> rules);
    public String name();
    public boolean imported();
}
