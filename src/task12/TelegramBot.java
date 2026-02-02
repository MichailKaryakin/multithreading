package task12;

public class TelegramBot {
    private final int REQUEST_LIMIT = 5; // Пункт 1
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() { // Пункт 2
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long now = System.currentTimeMillis();
        long timePassed = now - lastRequestTime;

        if (timePassed < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    long timeToWait = 1000 - timePassed;
                    System.out.println("Лимит исчерпан. Ждем " + timeToWait + " мс...");
                    Thread.sleep(timeToWait);

                    requestCounter = 1;
                    lastRequestTime = System.currentTimeMillis();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        } else {
            requestCounter = 1;
            lastRequestTime = now;
        }

        System.out.println(Thread.currentThread().getName() + " Отправлено: " + message + " (Запрос №" + requestCounter + ")");
    }
}