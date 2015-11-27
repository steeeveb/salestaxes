package src.main.java.salestaxes;


public class Tax {
    RoundingPolicy policy;

    public Tax(){
        this.policy = new RoundTo(0.05);
    }
    public TaxRule dutyFree(){
        return new PercentageTax(0, policy);
    }
    public TaxRule exemption(){
        return new PercentageTax(0, policy);
    }
    public TaxRule basic(){
        return new PercentageTax(10, policy);
    }
    public TaxRule duty(){
        return new PercentageTax(5, policy);
    }
}
