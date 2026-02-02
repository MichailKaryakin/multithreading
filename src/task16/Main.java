package task16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        School hogwarts = new School("Hogwarts",
                new ArrayList<>(Arrays.asList(
                        new Student("Harry Potter", 4, 0),
                        new Student("Cedric Diggory", 6, 0),
                        new Student("Hermione Granger", 4, 0)
                ))
        );

        School beauxbatons = new School("Beauxbatons",
                new ArrayList<>(Arrays.asList(
                        new Student("Fleur Delacour", 6, 0),
                        new Student("Gabrielle Delacour", 1, 0),
                        new Student("Olympe Maxime", 7, 0)
                ))
        );

        School durmstrang = new School("Durmstrang",
                new ArrayList<>(Arrays.asList(
                        new Student("Viktor Krum", 7, 0),
                        new Student("Polyakoff", 5, 0),
                        new Student("Igor Karkaroff", 7, 0)
                ))
        );

        Task dragonTask = new Task("Битва с драконом", 10, 500);
        Task underwaterTask = new Task("Спасение из озера", 7, 350);
        Task mazeTask = new Task("Лабиринт страха", 5, 250);

        Tournament tournament = new Tournament();

        CompletableFuture<School> task1 = tournament.startTask(hogwarts, dragonTask);
        CompletableFuture<School> task2 = tournament.startTask(beauxbatons, mazeTask);
        CompletableFuture<School> task3 = tournament.startTask(durmstrang, underwaterTask);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);

        allTasks.join();

        System.out.println("Количество очков хогвартса: " + hogwarts.getTotalPoints());
        System.out.println("Количество очков шармбатона: " + beauxbatons.getTotalPoints());
        System.out.println("Количество очков дурмстранга: " + durmstrang.getTotalPoints());

        System.out.println(decideOnWinner(hogwarts, beauxbatons, durmstrang));
    }

    public static String decideOnWinner(School... schools) {
        return Arrays.stream(schools)
                .max(Comparator.comparingInt(School::getTotalPoints))
                .map(s -> "Победитель: " + s.getName())
                .orElse("Победителей нет");
    }
}
