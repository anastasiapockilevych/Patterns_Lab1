package composite;
import java.util.ArrayList;
import java.util.List;

public class MotherboardComposite implements PcComponent {
    private String name;
    private List<PcComponent> components = new ArrayList<>();

    public MotherboardComposite(String name) { this.name = name; }

    public void addComponent(PcComponent component) { components.add(component); }

    @Override
    public int getPrice() {
        int total = 0;
        for (PcComponent c : components) { total += c.getPrice(); }
        return total;
    }

    @Override
    public void showDetails() {
        System.out.println("Вузол: " + name);
        for (PcComponent c : components) { c.showDetails(); }
    }
}