package task18;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);

                order.setStatus("Обработано");
                totalProcessedOrders.incrementAndGet();

                System.out.println("Заказ " + order.getId() + " успешно обработан");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
