package za.co.myemeris.st10468354.question2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesModelTest {

    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        ProductSalesModel model = new ProductSalesModel();
        assertEquals(2, model.GetSalesOverLimit(), "Expected 2 sales over the limit of 500");
    }

    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        ProductSalesModel model = new ProductSalesModel();
        assertEquals(4, model.GetSalesUnderLimit(), "Expected 4 sales under the limit of 500");
    }
}
