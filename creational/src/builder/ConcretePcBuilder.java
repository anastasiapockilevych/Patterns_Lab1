package builder;

import abstract_factory.PlatformFactory;
import factory.StorageDrive;
import factory_method.ComputerCase;
import prototype.SystemImage;

// ДОДАНО: implements ComputerBuilder
public class ConcretePcBuilder implements ComputerBuilder {
    private Computer computer;

    public ConcretePcBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.computer = new Computer();
    }

    @Override
    public void setSerialNumber(String serial) {
        computer.serialNumber = serial;
    }

    @Override
    public void buildPlatform(PlatformFactory factory) {
        computer.cpu = factory.createCpu();
        computer.motherboard = factory.createMotherboard();
    }

    @Override
    public void installCase(ComputerCase pcCase) {
        computer.pcCase = pcCase;
    }

    @Override
    public void installStorage(StorageDrive storage) {
        computer.storage = storage;
    }

    @Override
    public void installOs(SystemImage image) {
        computer.osImage = image.clone();
    }

    public Computer getResult() {
        Computer finishedPc = this.computer;
        this.reset();
        return finishedPc;
    }
}