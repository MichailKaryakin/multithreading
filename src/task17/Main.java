package task17;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private final NotificationManager notificationManager = new NotificationManager();

    public static void main(String[] args) {
        Main main = new Main();
        main.execute();
    }

    public void execute() {
        List<CompletableFuture<List<Notification>>> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futures.add(fetchNotification(i, "message" + i));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("--- Список полученных уведомлений ---");
        notificationManager.getNotificationList().forEach(System.out::println);
    }

    public CompletableFuture<List<Notification>> fetchNotification(int id, String message) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.supplyAsync(() -> notificationManager.addNotification(new Notification(id, message)));
    }
}
