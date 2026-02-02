package task15;

public record Kingdom(String name) {

    public void sendMessage(Kingdom target) {
        System.out.println("Письмо из " + this.name + " доставлено в " + target.name());
    }
}
