package task1;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Mail[] mails = new Mail[1000];

        for (int i = 0; i < mails.length; i++) {
            mails[i] = new Mail("placeholder");
        }

        int totalMails = 1000;
        int threadsCount = 5;
        int step = totalMails / threadsCount;

        for (int i = 0; i < totalMails; i += step) {
            SenderRunnable task = new SenderRunnable(i, i + step, mails);
            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Все сообщения успешно отправлены!");
    }
}