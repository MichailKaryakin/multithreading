package task7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight k1 = new Knight("de Guermantes");
        k1.addTrial(new Trial(k1.getName(), "rescue the fair maiden"));
        k1.addTrial(new Trial(k1.getName(), "sabotage antiroyalist's plot"));

        Knight k2 = new Knight("de La Trémoille");
        k2.addTrial(new Trial(k2.getName(), "exercise fencing skills on bandits"));
        k2.addTrial(new Trial(k2.getName(), "search the truth, in the night, alone..."));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        k1.startTrials(executorService);
        k2.startTrials(executorService);

        executorService.shutdown();
    }
}
