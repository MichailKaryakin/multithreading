package task22;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Substation {
    private final int id;
    private final MonitoringSystem monitoringSystem;
    private final Map<Integer, SensorData> sensorDataMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public Substation(int id, MonitoringSystem monitoringSystem) {
        this.id = id;
        this.monitoringSystem = monitoringSystem;
    }

    public void receiveData(int sensorId, double data) {
        sensorDataMap.computeIfAbsent(sensorId, k -> new SensorData()).addValue(data);
    }

    public void startCalculatingAverages() {
        scheduler.scheduleAtFixedRate(() -> {
            double totalSum = 0;
            int sensorsCount = 0;

            for (SensorData sd : sensorDataMap.values()) {
                totalSum += sd.getAverageAndReset();
                sensorsCount++;
            }

            double average = sensorsCount == 0 ? 0 : totalSum / sensorsCount;
            monitoringSystem.updateData(id, average);
        }, 1, 5, TimeUnit.SECONDS);
    }

}
