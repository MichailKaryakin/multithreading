package task20;

import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    private final ConcurrentHashMap<String, String> accounts = new ConcurrentHashMap<>();

    public void addData(String key, String value) {
        accounts.put(key, value);
    }

    public String getData(String key) {
        return accounts.get(key);
    }
}
