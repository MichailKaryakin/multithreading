package task15;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.executeTask();
    }

    private void executeTask() {
        Kingdom winterfell = new Kingdom("Винтерфелл");
        Kingdom kingsLanding = new Kingdom("Королевская Гавань");
        Kingdom dragonstone = new Kingdom("Драконий Камень");

        CompletableFuture<Void> raven1 = CompletableFuture.supplyAsync(() -> sendRaven(winterfell, kingsLanding))
                .handle((msg, ex) -> (ex != null) ? "Трагедия: " + ex.getMessage() : "Успех: " + msg)
                .thenAccept(System.out::println);

        CompletableFuture<Void> raven2 = CompletableFuture.supplyAsync(() -> sendRaven(dragonstone, winterfell))
                .handle((msg, ex) -> (ex != null) ? "Трагедия: " + ex.getMessage() : "Успех: " + msg)
                .thenAccept(System.out::println);

        CompletableFuture.allOf(raven1, raven2).join();

        System.out.println("Конец");
    }

    private String sendRaven(Kingdom origin, Kingdom destination) {
        Random random = new Random();
        int x = random.nextInt(11);
        if (x < 7) {
            origin.sendMessage(destination);
            return "ворон избежал обнаружения";
        } else {
            throw new RuntimeException("ворон был перехвачен врагом");
        }
    }
}
