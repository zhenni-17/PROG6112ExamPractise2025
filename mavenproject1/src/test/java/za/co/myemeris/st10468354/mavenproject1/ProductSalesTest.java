package za.co.myemeris.st10468354.mavenproject1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ProductSalesTest {
    
    private final int[] data = {300, 150, 700, 250, 200, 600};

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        ProductSales ps = new ProductSales();
        int result = ps.TotalSales(data);
        assertEquals(2200, result, "Total sales should be 2200");
    }

    @Test
    public void AverageSales_ReturnsAverageProductSales() {
        ProductSales ps = new ProductSales();
        double result = ps.AverageSales(data);
        assertEquals(366.6666666666667, result, 0.0001, "Average sales should be ~366.67");
    }
}
