import javax.swing.*;
import java.awt.*;

public class AccountingApp {
    
    public static void main(String[] args) {
        // AccountingApp 인스턴스 생성
        AccountingApp app = new AccountingApp();
        app.run();
    }

    public void run() {
        String input = JOptionPane.showInputDialog("시급을 입력하세요.");

        // 소수점 없는 경우 .0 추가
        if (input != null && !input.isEmpty() && !input.contains(".")) {
            input += ".0";
        }

        try {
            double value = Double.parseDouble(input);
            System.out.println("Entered Value: " + value);
            displayFinancialSummary(value);
        } catch (NumberFormatException e) {
            System.out.println("입력이 잘못되었습니다. 유효한 숫자를 입력하세요.");
        }
    }

    public void displayFinancialSummary(double value) {
        double vat = calculateVAT(value);
        double total = calculateTotal(value, vat);
        double expense = calculateExpense(value);
        double income = calculateIncome(value, expense);
        double[] dividends = calculateDividends(income, value);

        // GUI 관련 코드
        SwingUtilities.invokeLater(() -> createAndShowGUI(value, vat, total, expense, income, dividends));
    }

    private void createAndShowGUI(double value, double vat, double total, double expense, double income, double[] dividends) {
        JFrame frame = new JFrame("계산기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setLayout(new GridLayout(8, 1));

        String[] labels = {
            "Value of supply: " + value,
            "VAT: " + vat,
            "Total: " + total,
            "Expense: " + expense,
            "Income: " + income,
            "Dividend - 1: " + dividends[0],
            "Dividend - 2: " + dividends[1],
            "Dividend - 3: " + dividends[2]
        };

        for (String label : labels) {
            frame.getContentPane().add(new JLabel(label, SwingConstants.CENTER));
        }

        centerFrame(frame);
        frame.pack();
        frame.setVisible(true);
    }

    private void centerFrame(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getWidth() / 2, dim.height / 2 - frame.getHeight() / 2);
    }

    private double[] calculateDividends(double income, double value) {
        double[] ratesAbove10k = {0.5, 0.3, 0.2};
        double[] ratesBelow10k = {0.9, 0.7, 0.6};
        double[] selectedRates;

        if (value >= 10000.0) {
            selectedRates = ratesAbove10k;
        } else {
            selectedRates = ratesBelow10k;
        }

        return new double[]{
            calculateDividend(income, selectedRates[0]),
            calculateDividend(income, selectedRates[1]),
            calculateDividend(income, selectedRates[2])
        };
    }    

    public double calculateVAT(double value) {
        return value * 0.1;
    }

    public double calculateTotal(double value, double vat) {
        return value + vat;
    }

    public double calculateExpense(double value) {
        return value * 0.3;
    }

    public double calculateIncome(double value, double expense) {
        return value - expense;
    }

    public double calculateDividend(double income, double rate) {
        return income * rate;
    }
}
