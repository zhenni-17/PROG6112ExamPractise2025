package za.co.myemeris.st10468354.mavenproject1;

public class SalesReportApp {
    public static void main(String[] args) {
        // Two-dimensional array: rows = years, columns = quarters
        int[][] salesData = {
                {300, 150, 700},   // Year 1
                {250, 200, 600}    // Year 2
        };

        // Flatten 2D array into 1D array for calculations
        int[] flatSales = new int[salesData.length * salesData[0].length];
        int index = 0;
        for (int[] row : salesData) {
            for (int value : row) {
                flatSales[index++] = value;
            }
        }

        ProductSales ps = new ProductSales();
        int total = ps.TotalSales(flatSales);
        double average = ps.AverageSales(flatSales);
        int max = ps.MaxSale(flatSales);
        int min = ps.MinSale(flatSales);

        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("Total sales: " + total);
        System.out.printf("Average sales: %.0f%n", average);
        System.out.println("Maximum sale: " + max);
        System.out.println("Minimum sale: " + min);
    }
}
