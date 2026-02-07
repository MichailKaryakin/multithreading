package task21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        MilitaryBase baseAlpha = new MilitaryBase("Пентагон");
        MilitaryBase baseBeta = new MilitaryBase("Зона 51");

        executor.execute(baseAlpha);
        executor.execute(baseBeta);

        Thread.sleep(1000);

        System.out.println(">>> Начало передачи секретных данных...");
        baseAlpha.sendMessage(baseBeta, "Объект 'Орион' замечен в секторе 7. Прием.");
        baseBeta.sendMessage(baseAlpha, "Вас понял, Пентагон. Высылаю перехватчики.");

        Thread.sleep(3000);

        System.out.println(">>> Завершение миссии. Отключение баз...");
        baseAlpha.stop();
        baseBeta.stop();

        executor.shutdown();
        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }

        System.out.println("Система связи Пентагона отключена.");
    }
}