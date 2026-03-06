package abstract_factory;
public class AmdFactory implements PlatformFactory {
    public Cpu createCpu() { return new AmdCpu(); }
    public Motherboard createMotherboard() { return new AmdMotherboard(); }}