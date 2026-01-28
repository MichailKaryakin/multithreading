package task9;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread pauseThread = new Thread(() -> player.pause());
        Thread playThread = new Thread(() -> player.play());
        Thread skipThread = new Thread(() -> player.skip());
        Thread previousThread = new Thread(() -> player.previous());

        playThread.start();
        skipThread.start();
        previousThread.start();
        pauseThread.start();
    }
}