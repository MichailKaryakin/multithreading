package task13;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot("человек, сделавший мне больно");
        Robot robot1 = new Robot("человек, сделавший мне больно");

        Thread thread = new Thread(robot::attack);
        Thread thread1 = new Thread(robot1::attack);

        thread.start();
        thread1.start();
    }
}
