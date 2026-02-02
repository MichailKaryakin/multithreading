package task13;

public record Robot(String target) {

    public void attack() {
        synchronized (target) {
            System.out.println(Thread.currentThread().getName() + " Цель \"" + target + "\" захвачена");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " ХА-ХА-ХА, КУСОК МЯСА, ТЕБЕ ПРИШЁЛ КОНЕЦ");
        }
    }
}
