package task16;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Школа " + school.getName() + " приступила к заданию: " + task.getName());

                Thread.sleep(task.getDifficulty() * 100L);

                int pointsPerStudent = task.getReward() / school.getTeam().size();
                for (Student student : school.getTeam()) {
                    student.setPoints(student.getPoints() + pointsPerStudent);
                }

                System.out.println("Школа " + school.getName() + " завершила задание!");
                return school;
            } catch (InterruptedException e) {
                throw new RuntimeException("Турнир прерван!", e);
            }
        });
    }
}
