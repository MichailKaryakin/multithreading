package task23;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DeliveryService service = new DeliveryService();

        service.addPromoCode(new PromoCode(0.3, "SAVE30", new Date(System.currentTimeMillis() + 100000), 100));
        service.addPromoCode(new PromoCode(0.1, "SAVE10", new Date(System.currentTimeMillis() + 100000), 50));
        service.addPromoCode(new PromoCode(0.5, "BIG50", new Date(System.currentTimeMillis() + 100000), 500));

        List<Product> items = List.of(new Product("Pizza", 600), new Product("Cola", 100));

        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<String> userPromos = List.of("SAVE30", "SAVE10", "BIG50");

        System.out.println("Обработка заказов...");
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                Order order = new Order(items);
                service.processOrder(order, userPromos);
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("\nРезультаты...");
        System.out.println("Всего обработано заказов: " + service.getProcessedOrders().size());
        long usedCount = service.getProcessedOrders().stream()
                .filter(o -> o.getTotalPrice() < o.getBasePrice())
                .count();
        System.out.println("Заказов со скидкой: " + usedCount);
        System.out.println("Осталось активных промокодов в системе: " + service.getAllCodes().size());
    }
}
