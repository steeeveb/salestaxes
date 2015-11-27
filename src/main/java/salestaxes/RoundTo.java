package src.main.java.salestaxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundTo implements RoundingPolicy{
    double nearest;

    public RoundTo(double nearest){
        this.nearest = nearest;
    }
    public BigDecimal round(BigDecimal value){
        return value
            .divide(new BigDecimal(nearest), RoundingMode.CEILING)
            .setScale(0, RoundingMode.CEILING)
            .multiply(new BigDecimal(nearest));
    }
}
