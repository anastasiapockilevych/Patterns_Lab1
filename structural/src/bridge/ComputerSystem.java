package bridge;
public abstract class ComputerSystem {
    protected OperatingSystem os;
    public ComputerSystem(OperatingSystem os) { this.os = os; }
    public abstract void turnOn();
}