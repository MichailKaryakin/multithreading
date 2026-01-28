package task4;

public record Task(String name, String task) implements Runnable {

    @Override
    public void run() {
        System.out.println(name + " приступил к заданию: " + task);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Задание " + task + " для " + name + " было прервано");
        }
        System.out.println(name + " выполнил задание: " + task);
    }
}
