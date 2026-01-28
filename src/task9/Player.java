package task9;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Музыка уже играет.");
                return;
            }
            isPlaying = true;
            System.out.println("Воспроизведение начато.");
            lock.notifyAll();
        }
    }

    public void pause() {
        synchronized (lock) {
            while (!isPlaying) {
                try {
                    System.out.println("Пауза ждет начала воспроизведения...");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            isPlaying = false;
            System.out.println("Музыка поставлена на паузу.");
            lock.notifyAll();
        }
    }

    public void skip() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Музыка не играет.");
                return;
            }
            isPlaying = false;
            try {
                System.out.println("Трек переключается вперед...");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            isPlaying = true;
            System.out.println("Воспроизведение начато.");
            lock.notifyAll();
        }
    }

    public void previous() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Музыка не играет.");
                return;
            }
            isPlaying = false;
            try {
                System.out.println("Трек переключается назад...");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            isPlaying = true;
            System.out.println("Воспроизведение начато.");
            lock.notifyAll();
        }
    }
}
