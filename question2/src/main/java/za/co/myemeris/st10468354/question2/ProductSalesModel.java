package za.co.myemeris.st10468354.question2;

public class ProductSalesModel implements IProductSales {

    private static final int SALES_LIMIT = 500;

    private final int[][] productSales = {
            {300, 150, 700},   // Year 1
            {250, 200, 600}    // Year 2
    };

    @Override
    public int[][] GetProductSales() {
        return productSales;
    }

    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] row : productSales) {
            for (int val : row) {
                total += val;
            }
        }
        return total;
    }

    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] row : productSales) {
            for (int val : row) {
                if (val > SALES_LIMIT) count++;
            }
        }
        return count;
    }

    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] row : productSales) {
            for (int val : row) {
                if (val < SALES_LIMIT) count++;
            }
        }
        return count;
    }

    @Override
    public int GetProductsProcessed() {
        return productSales.length;
    }

    @Override
    public double GetAverageSales() {
        int count = productSales.length * productSales[0].length;
        if (count == 0) return 0.0;
        return (double) GetTotalSales() / count;
    }
}
