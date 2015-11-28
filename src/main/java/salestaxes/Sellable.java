package src.main.java.salestaxes;
import java.math.BigDecimal;
import java.util.Set;

public interface Sellable{
    public BigDecimal total();
    public BigDecimal salesTaxes();
    public String description();
    public Sellable setTaxes(Set<TaxRule> rules);
    public Sellable setTaxes(TaxRule... rules);
    public boolean imported();
}
