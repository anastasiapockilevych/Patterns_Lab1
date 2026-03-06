
package builder;
import factory.StorageDrive;
import prototype.SystemImage;
import abstract_factory.PlatformFactory;
import factory_method.ComputerCase;

public interface ComputerBuilder {
    void reset();
    void setSerialNumber(String serial);
    void buildPlatform(PlatformFactory factory);
    void installCase(ComputerCase pcCase);
    void installStorage(StorageDrive storage);
    void installOs(SystemImage image);
    Computer getResult();
}