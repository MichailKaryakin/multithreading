package task3;

public class Pig3Thread extends PigThread {
    public Pig3Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Дом построил " + super.getPigName() + " из материала: " + super.getMaterial());
    }
}
