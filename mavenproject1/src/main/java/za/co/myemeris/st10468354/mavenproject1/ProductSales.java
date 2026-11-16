package za.co.myemeris.st10468354.mavenproject1;

public class ProductSales implements IProduct {

    @Override
    public int TotalSales(int[] productSales) {
        int total = 0;
        for (int sale : productSales) {
            total += sale;
        }
        return total;
    }

    @Override
    public double AverageSales(int[] productSales) {
        if (productSales.length == 0) return 0.0;
        return (double) TotalSales(productSales) / productSales.length;
    }

    @Override
    public int MaxSale(int[] productSales) {
        if (productSales.length == 0) return 0;
        int max = productSales[0];
        for (int sale : productSales) {
            if (sale > max) max = sale;
        }
        return max;
    }

    @Override
    public int MinSale(int[] productSales) {
        if (productSales.length == 0) return 0;
        int min = productSales[0];
        for (int sale : productSales) {
            if (sale < min) min = sale;
        }
        return min;
    }
}
