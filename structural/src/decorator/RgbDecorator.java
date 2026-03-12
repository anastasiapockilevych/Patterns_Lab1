package decorator;
public class RgbDecorator extends PcDecorator {
    public RgbDecorator(PcSetup setup) { super(setup); }
    public String getDescription() { return setup.getDescription() + " + RGB підсвітка"; }
    public int getCost() { return setup.getCost() + 50; }
}