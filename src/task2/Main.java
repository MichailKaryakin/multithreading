package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.MINUTES;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person("Имя " + i, "Фамилия", 19, "google"));
        }

        int threadsCount = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);

        int totalSize = persons.size();
        int step = totalSize / threadsCount;

        for (int i = 0; i < totalSize; i += step) {
            executorService.submit(new PersonNamePrinter(persons.subList(i, i + step)));
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, MINUTES)) {
                System.out.println("Программа завершена!");
            } else {
                System.out.println("Время ожидания истекло, а потоки еще работают");
            }
        } catch (InterruptedException e) {
            System.err.println("Ожидание было прервано");
            Thread.currentThread().interrupt();
        }
    }
}