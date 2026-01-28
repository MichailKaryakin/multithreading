package task6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"clean the toilet", "change hair color", "find Ron's rat", "steal the car and go fetch Harry", "pacify Ginny"};

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executorService.execute(new Chore(chore));
        }

        executorService.shutdown();
    }
}
