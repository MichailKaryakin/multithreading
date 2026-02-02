package task11;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoManager {
    private final ConcurrentHashMap<String, AtomicInteger> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsMap.computeIfAbsent(videoId, k -> new AtomicInteger(0))
                .incrementAndGet();
    }

    public int getViewCount(String videoId) {
        AtomicInteger count = viewsMap.get(videoId);
        return (count == null) ? 0 : count.get();
    }
}