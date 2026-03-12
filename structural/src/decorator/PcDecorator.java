package decorator;
public abstract class PcDecorator implements PcSetup {
    protected PcSetup setup;
    public PcDecorator(PcSetup setup) { this.setup = setup; }
    public String getDescription() { return setup.getDescription(); }
    public int getCost() { return setup.getCost(); }
}