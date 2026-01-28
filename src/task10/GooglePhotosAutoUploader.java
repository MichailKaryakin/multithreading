package task10;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " Список пустой... Жду добавлений!");
                        lock.wait();
                        System.out.println(Thread.currentThread().getName() + " Просыпаюсь!");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    uploadPhotos();
                }
            }
        }
    }

    public void uploadPhotos() {
        for (String path : photosToUpload) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " Фото по пути: " + path + " - загружено");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(Thread.currentThread().getName() + " Новое фото добавлено");
            lock.notify();
        }
    }
}
