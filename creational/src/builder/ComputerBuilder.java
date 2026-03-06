package builder;

import abstract_factory.PlatformFactory;
import factory.StorageDrive;
import factory_method.ComputerCase;
import prototype.SystemImage;

public interface ComputerBuilder {
    void reset();
    void setSerialNumber(String serial);
    void buildPlatform(PlatformFactory factory);
    void installCase(ComputerCase pcCase);
    void installStorage(StorageDrive storage);
    void installOs(SystemImage image);
}