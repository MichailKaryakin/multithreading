package task7;

public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.println("Honorable sir " + knightName + " started the following trial: " + trialName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Courageous sir " + knightName + " finished the trial: " + trialName);
    }
}
