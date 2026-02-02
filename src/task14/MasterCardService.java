package task14;

import java.util.Random;

public class MasterCardService {

    public int collectPayment() {
        System.out.println("Начинаем сбор платежа...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        int amount = new Random().nextInt(1000);
        System.out.println("Платеж на сумму " + amount + " собран!");
        return amount;
    }

    public int sendAnalytics() {
        System.out.println("Отправка данных в MasterCard...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Аналитика успешно доставлена.");
        return 200;
    }
}