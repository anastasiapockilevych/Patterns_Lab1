package abstract_factory;
public interface PlatformFactory {
    Cpu createCpu();
    Motherboard createMotherboard();}