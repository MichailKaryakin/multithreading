package task20;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws InterruptedException {
        CollaborativeDocument doc = new CollaborativeDocument();

        doc.addData("section1", "какой-то текст в первом разделе");
        doc.addData("section2", "какой-то текст во втором разделе");
        doc.addData("section3", "какой-то текст в третьем разделе");

        DocumentSection s1 = new DocumentSection("section1", doc);
        DocumentSection s2 = new DocumentSection("section2", doc);
        DocumentSection s3 = new DocumentSection("section3", doc);

        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(new DocumentSectionProcessor(s1), "Processor-1"));
        threads.add(new Thread(new DocumentSectionProcessor(s2), "Processor-2"));
        threads.add(new Thread(new DocumentSectionProcessor(s3), "Processor-3"));

        for (Thread t : threads) t.start();

        for (Thread t : threads) t.join();

        System.out.println("Результаты");
        System.out.println("Раздел 1: " + doc.getData("section1"));
        System.out.println("Раздел 2: " + doc.getData("section2"));
        System.out.println("Раздел 3: " + doc.getData("section3"));
    }
}