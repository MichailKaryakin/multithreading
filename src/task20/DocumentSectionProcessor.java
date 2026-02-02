package task20;

public record DocumentSectionProcessor(DocumentSection section) implements Runnable {

    @Override
    public void run() {
        String originalData = section.readContent();

        String processedData = (originalData != null) ? originalData.toUpperCase() : "ПУСТО";

        section.writeContent(processedData + " (Обработано потоком " + Thread.currentThread().getName() + ")");
    }
}