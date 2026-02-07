package task21;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MilitaryBase implements Runnable {
    private final String name;
    private final BlockingQueue<String> inbox = new LinkedBlockingQueue<>();
    private volatile boolean running = true;

    public MilitaryBase(String name) {
        this.name = name;
    }

    public void sendMessage(MilitaryBase target, String message) {
        try {
            String encrypted = EncryptionUtils.encrypt(message);
            target.inbox.put(encrypted);
        } catch (Exception e) {
            System.err.println("Ошибка отправки из " + name);
        }
    }

    public void stop() {
        this.running = false;
    }

    @Override
    public void run() {
        System.out.println(name + " на связи...");
        while (running) {
            try {
                String encryptedMsg = inbox.poll(1, TimeUnit.SECONDS);
                if (encryptedMsg != null) {
                    String decrypted = EncryptionUtils.decrypt(encryptedMsg);
                    System.out.println("[" + name + "] Получены разведданные: " + decrypted);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(name + " отключена.");
    }
}