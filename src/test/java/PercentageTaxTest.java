package src.test.java;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import src.main.java.*;
import src.main.java.salestaxes.*;


public class PercentageTaxTest {

    @Test
    public void test20percentTax() {
        RoundingPolicy round = new RoundTo(0.05);
        TaxRule tax = new PercentageTax(20, round);
        BigDecimal result = tax.compute(new BigDecimal(10));
        assertThat(result, is(closeTo(new BigDecimal(2), new BigDecimal(0.001))));
    }
}
