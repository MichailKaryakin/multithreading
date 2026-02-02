package task14;

import java.util.concurrent.*;

public class Main {
    private final MasterCardService masterCardService = new MasterCardService();

    public static void main(String[] args) {
        Main main = new Main();
        main.doAll();
    }

    public void doAll() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> paymentFuture = executorService.submit(masterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(masterCardService::sendAnalytics, executorService);

        System.out.println("Результат отправки аналитики: " + analyticsFuture.join());

        try {
            System.out.println("Собранный платёж: " + paymentFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
