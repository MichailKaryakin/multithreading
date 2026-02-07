package task22;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class MonitoringSystem {
    private final Map<Integer, Double> substationData = new ConcurrentHashMap<>();

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        System.out.printf("Подстанция %d: среднее значение = %.2f%n", substationId, averageData);
    }
}
