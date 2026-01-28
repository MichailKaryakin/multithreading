package task1;

public record SenderRunnable(int startIndex, int endIndex, Mail[] mail) implements Runnable {

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо номер " + i + " успешно отправлено");
        }
    }
}
