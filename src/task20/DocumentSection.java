package task20;

public record DocumentSection(String id, CollaborativeDocument document) {

    public String readContent() {
        return document.getData(id);
    }

    public void writeContent(String newContent) {
        document.addData(id, newContent);
    }
}