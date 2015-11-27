package src.test.java;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.number.BigDecimalCloseTo.*;


import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import src.main.java.*;


public class LineParserTest {
    @Test
    public void aParserCanParseALine() {
        LineParser parser = new LineParser();
        String input = "1 book at 12.49\n";
        List<InputLine> lines = new ArrayList<>();
        lines.add(new InputLine("1 book", new BigDecimal("12.49")));
        assertThat(parser.parse(input), is(equalTo(lines)));
    }

    @Test
    public void aParserCanParse2Lines() {
        LineParser parser = new LineParser();
        String input = "1 book at 12.49\n1 music cd at 14.99";
        List<InputLine> lines = new ArrayList<>();
        lines.add(new InputLine("1 book", new BigDecimal("12.49")));
        lines.add(new InputLine("1 music cd", new BigDecimal("14.99")));
        assertThat(parser.parse(input), is(equalTo(lines)));
    }
}
