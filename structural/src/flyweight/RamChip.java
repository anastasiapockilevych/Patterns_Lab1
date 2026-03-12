package flyweight;

public class RamChip {
    private String manufacturer;
    private int speedMHz;

    public RamChip(String manufacturer, int speedMHz) {
        this.manufacturer = manufacturer;
        this.speedMHz = speedMHz;
        System.out.println("   [Flyweight] Створено новий еталон чипа: " + manufacturer + " " + speedMHz + "MHz");
    }

    public void render(int position) {
        System.out.println("Встановлено чип [" + manufacturer + "] на позицію: " + position);
    }
}