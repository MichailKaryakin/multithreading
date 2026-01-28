package task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBandTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(new Task("Sheldon", "подготовка теории"));
        executorService.execute(new Task("Leonard", "моделирование эксперимента"));
        executorService.execute(new Task("Howard", "разработка инструментов"));
        executorService.execute(new Task("Rajesh", "анализ данных"));

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Выполнение завершено");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
