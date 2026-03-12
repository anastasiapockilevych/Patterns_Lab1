package builder;

import abstract_factory.PlatformFactory;
import factory.StorageDrive;
import factory_method.ComputerCase;
import prototype.SystemImage;

public interface ComputerBuilder {
    ComputerBuilder reset();
    ComputerBuilder setSerialNumber(String serial);
    ComputerBuilder buildPlatform(PlatformFactory factory);
    ComputerBuilder installCase(ComputerCase pcCase);
    ComputerBuilder installStorage(StorageDrive storage);
    ComputerBuilder installOs(SystemImage image);
    Computer getResult();
}