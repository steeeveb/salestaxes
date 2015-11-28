package src.main.java.salestaxes;


public class TaxFactory {
    RoundingPolicy policy;

    public TaxFactory(){
        this.policy = new RoundTo(0.05);
    }
    public TaxRule basic(){
        return new PercentageTax(10, policy);
    }
    public TaxRule duty(){
        return new PercentageTax(5, policy);
    }
}
