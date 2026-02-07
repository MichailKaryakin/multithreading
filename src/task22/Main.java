package task22;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();
        List<Substation> substations = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            Substation sub = new Substation(i, monitoringSystem);
            substations.add(sub);

            for (int j = 1; j <= 10; j++) {
                Sensor sensor = new Sensor(j, sub);
                sensor.startGeneratingData();
            }

            sub.startCalculatingAverages();
        }

        System.out.println("Система мониторинга запущена. Ожидайте данных...");
    }
}
