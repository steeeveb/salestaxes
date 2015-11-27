package src.main.java.salestaxes;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class PercentageTax implements TaxRule{
    private BigDecimal percentage;
    private RoundingPolicy policy;

    public PercentageTax(int percentage, RoundingPolicy policy){
        this.percentage = new BigDecimal(percentage);
        this.policy = policy;
    }

    public BigDecimal compute(BigDecimal price){
        BigDecimal result =  price.divide(new BigDecimal(100)).multiply(percentage);
        return policy.round(result);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        PercentageTax other = (PercentageTax) obj;
        return other.percentage.equals(percentage);
    }

    @Override
    public int hashCode(){
        return percentage.hashCode();
    }
}
