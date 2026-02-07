package task22;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

class Sensor {
    private final int id;
    private final Substation substation;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public Sensor(int id, Substation substation) {
        this.id = id;
        this.substation = substation;
    }

    public void startGeneratingData() {
        scheduler.scheduleAtFixedRate(() -> {
            double value = random.nextDouble(10.0, 100.0);
            substation.receiveData(id, value);
        }, 0, 1, TimeUnit.SECONDS);
    }
}
