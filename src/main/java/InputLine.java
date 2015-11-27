package src.main.java;
import java.math.BigDecimal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputLine{
    final public String description;
    final public BigDecimal price;

    public InputLine(String description, BigDecimal price){
        this.description = description;
        this.price = price;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        InputLine other = (InputLine) obj;
        return description.equals(other.description) && price.equals(other.price);
    }

    public static InputLine parse(String line){
        String expression = "^(.*) at ([0-9]+\\.[0-9][0-9]).*$";
        Pattern pattern = Pattern.compile(expression);

        Matcher m = pattern.matcher(line);
        if (m.find( )) {
            return new InputLine(m.group(1), new BigDecimal(m.group(2)));
        } else {
            return null;
        }
    }
}
