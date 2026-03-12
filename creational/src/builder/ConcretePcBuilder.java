package builder;

import abstract_factory.PlatformFactory;
import factory.StorageDrive;
import factory_method.ComputerCase;
import prototype.SystemImage;

public class ConcretePcBuilder implements ComputerBuilder {
    private Computer computer;

    public ConcretePcBuilder() {
        this.reset();
    }

    @Override
    public ComputerBuilder reset() {
        this.computer = new Computer();
        return this;
    }

    @Override
    public ComputerBuilder setSerialNumber(String serial) {
        computer.serialNumber = serial;
        return this; // Повертаємо this для чейнінгу
    }

    @Override
    public ComputerBuilder buildPlatform(PlatformFactory factory) {
        computer.cpu = factory.createCpu();
        computer.motherboard = factory.createMotherboard();
        return this;
    }

    @Override
    public ComputerBuilder installCase(ComputerCase pcCase) {
        computer.pcCase = pcCase;
        return this;
    }

    @Override
    public ComputerBuilder installStorage(StorageDrive storage) {
        computer.storage = storage;
        return this;
    }

    @Override
    public ComputerBuilder installOs(SystemImage image) {
        computer.osImage = image.clone();
        return this;
    }

    @Override
    public Computer getResult() {
        Computer finishedPc = this.computer;
        this.reset();
        return finishedPc;
    }
}