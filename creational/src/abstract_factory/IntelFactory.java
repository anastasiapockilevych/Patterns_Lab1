package abstract_factory;
public class IntelFactory implements PlatformFactory {
    public Cpu createCpu() { return new IntelCpu(); }
    public Motherboard createMotherboard() { return new IntelMotherboard(); }}