package task8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SpaceXPlanner {

    public static long planRocketLaunches(List<RocketLaunch> launches) {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (RocketLaunch rocket : launches) {
            executor.submit(() -> {
                long currentTime = System.currentTimeMillis();
                long waitTime = rocket.getLaunchTime() - (currentTime - startTime);

                if (waitTime > 0) {
                    try {
                        Thread.sleep(waitTime);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                rocket.launch();
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        List<RocketLaunch> fleet = new ArrayList<>();

        fleet.add(new RocketLaunch("Falcon 9", 2000));
        fleet.add(new RocketLaunch("Starship", 5000));
        fleet.add(new RocketLaunch("Falcon Heavy", 8000));

        System.out.println("Планирование запусков...");
        long totalDuration = planRocketLaunches(fleet);

        System.out.println("Общее время выполнения метода: " + totalDuration + " мс");
    }
}