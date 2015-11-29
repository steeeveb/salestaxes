package src.test.java;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.number.BigDecimalCloseTo.*;


import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import src.main.java.*;
import src.main.java.salestaxes.*;


public class PaperTest {
    ProductBuilder aProduct = new ProductBuilder();

    @Test
    public void testFooter() {
        String input = "";
        String givenReceipt =
            "Sales Taxes: 1.00\n" +
            "Total: 9.50";
        Display paper = new Paper();
        String receipt = paper.print(new BigDecimal(1), new BigDecimal(9.5));
        assertThat(receipt, is(equalTo(givenReceipt)));
    }

    @Test
    public void test1Line() {
        String input = "";
        String givenReceipt =
            "1 music CD: 11.00\n" +
            "Sales Taxes: 1.00\n" +
            "Total: 11.00";
        TaxableItem product = aProduct.called("music CD").priced("10").build();
        Display paper = new Paper();
        paper.addLine(product, new BigDecimal(11));
        String receipt = paper.print(new BigDecimal(1), new BigDecimal(11));
        assertThat(receipt, is(equalTo(givenReceipt)));
    }

    @Test
    public void test1Imported() {
        String input = "";
        String givenReceipt =
            "1 imported music CD: 11.00\n" +
            "Sales Taxes: 1.00\n" +
            "Total: 11.00";
        TaxableItem product = aProduct.called("music CD").priced("10").imported().build();
        Display paper = new Paper();
        paper.addLine(product, new BigDecimal(11));
        String receipt = paper.print(new BigDecimal(1), new BigDecimal(11));
        assertThat(receipt, is(equalTo(givenReceipt)));
    }
}
