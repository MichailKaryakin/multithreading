package task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.MINUTES;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(new Pig1Thread("Ниф-ниф", "Известняк"));
        executorService.execute(new Pig1Thread("Наф-наф", "Мрамор"));
        executorService.execute(new Pig1Thread("Нуф-нуф", "Римский бетон"));

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, MINUTES)) {
                System.out.println("Программа завершена!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
