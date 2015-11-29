package src.main.java.salestaxes;
import java.math.*;
import java.util.*;


import src.main.java.salestaxes.*;


public class Receipt{
    private List<Line> lines = new ArrayList<>();

    public BigDecimal salesTaxes(){
        BigDecimal result = new BigDecimal(0);
        for (Line line: lines){
            result = result.add(line.salesTaxes());
        }
        return result;
    }

    public BigDecimal total(){
        BigDecimal result = new BigDecimal(0);
        for (Line line: lines){
            result = result.add(line.total());
        }
        return result;
    }

    public void add(TaxableItem product, List<TaxRule> taxes){
        lines.add(new Line(product, taxes));
    }

    public String print(Display display){
        for (Line line : lines){
            display.addLine(line.product, line.total());
        }
        return display.print(salesTaxes(), total());
    }

    private class Line{
        private final TaxableItem product;
        private final List<TaxRule> taxes;

        public Line(TaxableItem product, List<TaxRule> taxes){
            this.product = product;
            this.taxes = taxes;
        }

        private BigDecimal salesTaxes(){
            return product.salesTaxes(taxes);
        }

        private BigDecimal total(){
            return product.total(taxes);
        }
    }
}

