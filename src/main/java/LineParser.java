package src.main.java;

import java.math.BigDecimal;

import java.util.*;


public class LineParser implements Parser{
    public List<InputLine> parse(String input){
        String[] lines = input.split("\n");
        List<InputLine> result = new ArrayList<>();
        for (String line: lines){
            InputLine parsedLine = InputLine.parse(line);
            if (parsedLine != null){
                result.add(parsedLine);
            }
        }
        return result;
    }

}
