package task5;

public class CashierThread extends Thread {
    private final int cashierId;
    private final int[] customerItems;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        int totalValue = 0;
        for (int item : customerItems) {
            totalValue += item;
        }
        System.out.println("Кассир №" + cashierId + ": обработано товаров - "
                + customerItems.length + ", сумма - " + totalValue);
    }
}
