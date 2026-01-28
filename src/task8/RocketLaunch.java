package task8;

public class RocketLaunch {
    private String name;
    private long launchTime;

    public RocketLaunch(String name, long launchTime) {
        this.name = name;
        this.launchTime = launchTime;
    }

    public void launch() {
        try {
            Thread.sleep(1000);
            System.out.println("Ракета " + name + " запущена");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public long getLaunchTime() {
        return launchTime;
    }

    public String getName() {
        return name;
    }
}