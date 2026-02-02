package task10;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploaderThread = new Thread(uploader::startAutoUpload);

        Thread adderThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(500);
                    uploader.onNewPhotoAdded("path/to/photo" + i + ".jpg");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        uploaderThread.start();
        adderThread.start();
    }
}
