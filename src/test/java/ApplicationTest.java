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


public class ApplicationTest {
    TaxFactory tax = new TaxFactory();

    @Test
    public void test1book() {
        String input = "";
        String givenReceipt =
            "1 book: 12.49\n" +
            "Sales Taxes: 0.00\n" +
            "Total: 12.49";
        ProductRepository repository = new FakeRepository("book", "12.49");
        Application application = new Application(repository, new TaxOffice(), new Paper());
        assertThat(application.receipt(input), is(equalTo(givenReceipt)));
    }
    @Test
    public void test1MusicCd() {
        String input = "";
        String givenReceipt =
            "1 music CD: 11.00\n" +
            "Sales Taxes: 1.00\n" +
            "Total: 11.00";
        ProductRepository repository = new FakeRepository("music CD", "10", tax.basic());
        Application application = new Application(repository, new TaxOffice(), new Paper());
        assertThat(application.receipt(input), is(equalTo(givenReceipt)));
    }

    @Test
    public void testABookAndABook() {
        String input = "\n \n";
        String givenReceipt =
            "1 book: 12.49\n" +
            "1 book: 12.49\n" +
            "Sales Taxes: 0.00\n" +
            "Total: 24.98";
        ProductRepository repository = new FakeRepository("book", "12.49");
        Application application = new Application(repository, new TaxOffice(), new Paper());
        assertThat(application.receipt(input), is(equalTo(givenReceipt)));
    }
}

class FakeRepository implements ProductRepository {
    private  Sellable product;

    public FakeRepository(String description , String price, TaxRule... rules){
        this.product = new Product(description, new BigDecimal(price), rules);
    }

    public Sellable get(String line) throws ProductNotFound{
        return product;
    }

}
