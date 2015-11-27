package src.test.java;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.number.BigDecimalCloseTo.*;


import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import src.main.java.*;


public class InputLineTest {
    @Test
    public void anInputLineIsEqualsToItSelf() {
        InputLine line = new InputLine("1 book", new BigDecimal(12.49));
        assertThat(line, is(equalTo(line)));
    }

    @Test
    public void anInputLineIsEqualsToASimilarLine() {
        InputLine line1 = new InputLine("1 book", new BigDecimal(12.49));
        InputLine line2 = new InputLine("1 book", new BigDecimal(12.49));
        assertThat(line1, is(equalTo(line2)));
    }

    @Test
    public void anInputLineIsNotEqualsToAnotherLine() {
        InputLine line1 = new InputLine("1 book", new BigDecimal(12.49));
        InputLine line2 = new InputLine("1 cd", new BigDecimal(12.49));
        assertThat(line1, is(not(equalTo(line2))));
    }
}

