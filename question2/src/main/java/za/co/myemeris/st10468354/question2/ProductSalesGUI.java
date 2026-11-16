package za.co.myemeris.st10468354.question2;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProductSalesGUI extends JFrame {

    private final ProductSalesModel model = new ProductSalesModel();

    private JButton btnLoad;
    private JButton btnSave;
    private JTextArea txtReport;
    private JLabel lblYearsProcessed;

    private JMenuItem miExit;
    private JMenuItem miLoad;
    private JMenuItem miSave;
    private JMenuItem miClear;

    public ProductSalesGUI() {
        setTitle("Product Sales Application");
        setSize(420, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        buildMenu();
        buildForm();
    }

    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        miExit = new JMenuItem("Exit");
        miExit.addActionListener(e -> System.exit(0));
        fileMenu.add(miExit);

        JMenu toolsMenu = new JMenu("Tools");
        miLoad = new JMenuItem("Load Product Data");
        miSave = new JMenuItem("Save Product Data");
        miClear = new JMenuItem("Clear");

        miLoad.addActionListener(e -> loadProductData());
        miSave.addActionListener(e -> saveProductData());
        miClear.addActionListener(e -> clearAll());

        toolsMenu.add(miLoad);
        toolsMenu.add(miSave);
        toolsMenu.add(miClear);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    private void buildForm() {
        JPanel topPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        btnLoad = new JButton("Load Product Data");
        btnSave = new JButton("Save Product Data");
        topPanel.add(btnLoad);
        topPanel.add(btnSave);

        txtReport = new JTextArea();
        txtReport.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtReport);

        lblYearsProcessed = new JLabel("Years Processed: 0");

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(lblYearsProcessed, BorderLayout.SOUTH);

        btnLoad.addActionListener(e -> loadProductData());
        btnSave.addActionListener(e -> saveProductData());
    }

    private void loadProductData() {
        int total = model.GetTotalSales();
        double average = model.GetAverageSales();
        int over = model.GetSalesOverLimit();
        int under = model.GetSalesUnderLimit();
        int years = model.GetProductsProcessed();

        String report = String.format(
                "Total Sales: %d%n" +
                "Average Sales: %.0f%n" +
                "Sales over limit: %d%n" +
                "Sales under limit: %d%n",
                total, average, over, under);

        txtReport.setText(report);
        lblYearsProcessed.setText("Years Processed: " + years);
    }

    private void saveProductData() {
        if (txtReport.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Nothing to save. Load product data first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String output = "DATA LOG\n" +
                "*********************************\n" +
                txtReport.getText() +
                "*********************************\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            writer.write(output);
            JOptionPane.showMessageDialog(this, "Data saved to data.txt successfully.", "Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearAll() {
        txtReport.setText("");
        lblYearsProcessed.setText("Years Processed: 0");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductSalesGUI().setVisible(true));
    }
}
