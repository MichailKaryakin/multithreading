package task3;

public abstract class PigThread extends Thread {
    private String pigName;
    private String material;

    public PigThread(String pigName, String material) {
        this.pigName = pigName;
        this.material = material;
    }

    @Override
    public abstract void run();

    public String getPigName() {
        return pigName;
    }

    public void setPigName(String pigName) {
        this.pigName = pigName;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
