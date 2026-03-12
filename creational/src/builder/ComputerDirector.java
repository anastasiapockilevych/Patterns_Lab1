package builder;

import abstract_factory.IntelFactory;
import abstract_factory.AmdFactory;
import factory.StorageFactory;
import factory_method.GamingCaseManufacturer;
import factory_method.ServerCaseManufacturer;
import prototype.WindowsGamingImage;
import prototype.UbuntuServerImage;

public class ComputerDirector {

    public void constructGamingPc(ComputerBuilder builder, String serial) {
        builder.reset()
                .setSerialNumber(serial)
                .buildPlatform(new IntelFactory())
                .installCase(new GamingCaseManufacturer().manufactureCase())
                .installStorage(StorageFactory.createStorage("nvme"))
                .installOs(new WindowsGamingImage());
    }

    public void constructServerPc(ComputerBuilder builder, String serial) {
        builder.reset()
                .setSerialNumber(serial)
                .buildPlatform(new AmdFactory())
                .installCase(new ServerCaseManufacturer().manufactureCase())
                .installStorage(StorageFactory.createStorage("hdd"))
                .installOs(new UbuntuServerImage());
    }
}