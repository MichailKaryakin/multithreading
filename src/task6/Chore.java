package task6;

public class Chore implements Runnable {
    private String task;

    public Chore(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " приступил к задаче: " + task);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " выполнил задачу: " + task);
    }
}
