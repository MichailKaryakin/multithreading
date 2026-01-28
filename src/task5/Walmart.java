package task5;

public class Walmart {
    public static void main(String[] args) {
        int[][] customers = {
                {10, 20, 30},
                {100, 50},
                {5, 5, 5, 5, 5},
                {1000}
        };

        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i + 1, customers[i]);
        }

        for (CashierThread cashier : cashiers) {
            cashier.start();
        }
    }
}
