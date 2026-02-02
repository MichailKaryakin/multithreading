package task17;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private final List<Notification> notificationList = new ArrayList<>();

    public synchronized List<Notification> addNotification(Notification notification) {
        notificationList.add(notification);
        return notificationList;
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }
}
