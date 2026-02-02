package task18;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Order order = new Order("ORD-" + i, "Подан");
            futures.add(processor.processOrder(order));
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );

        System.out.println("Ожидание завершения всех заказов...");
        allOf.join();

        System.out.println("Все задачи выполнены");
        System.out.println("Общее количество обработанных заказов: " + processor.getTotalProcessedOrders());
    }
}