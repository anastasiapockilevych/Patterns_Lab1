package composite;
public class SimplePart implements PcComponent {
    private String name;
    private int price;

    public SimplePart(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int getPrice() { return price; }

    @Override
    public void showDetails() { System.out.println(" - " + name + " ($" + price + ")"); }
}