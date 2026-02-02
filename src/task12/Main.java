package task12;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        for (int i = 1; i <= 10; i++) {
            int number = i;
            new Thread(() -> bot.sendMessage("Привет №" + number)).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }
        System.out.println("Задача выполнена.");
    }
}