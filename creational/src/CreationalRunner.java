import abstract_factory.*;
import builder.*;
import factory.*;
import factory_method.*;
import prototype.*;
import singleton.*;

public class CreationalRunner {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println("----------Abstract factory begin---------");
        PlatformFactory intelFactory = PlatformFactoryMaker.makeFactory(PlatformType.INTEL);
        System.out.println("Intel CPU: " + intelFactory.createCpu().getCpuName());
        System.out.println("Intel Motherboard: " + intelFactory.createMotherboard().getBoardName());

        PlatformFactory amdFactory = PlatformFactoryMaker.makeFactory(PlatformType.AMD);
        System.out.println("AMD CPU: " + amdFactory.createCpu().getCpuName());
        System.out.println("AMD Motherboard: " + amdFactory.createMotherboard().getBoardName());
        System.out.println("-----------Abstract factory end----------");
        System.out.println();

        System.out.println("----------Builder begin---------");
        ComputerDirector director = new ComputerDirector();
        // Виправлений Builder:
        ConcretePcBuilder pcBuilder = new ConcretePcBuilder();

        director.constructGamingPc(pcBuilder, "SN-GAMER-123");
        Computer gamingPc = pcBuilder.getResult();
        System.out.println("Зібрано: " + gamingPc.getClass().getSimpleName() + " [Ігровий]");

        director.constructServerPc(pcBuilder, "SN-SERVER-456");
        Computer serverPc = pcBuilder.getResult();
        System.out.println("Зібрано: " + serverPc.getClass().getSimpleName() + " [Серверний]");
        System.out.println("----------Builder end----------");
        System.out.println();

        System.out.println("----------Factory start----------");
        System.out.println("Storage factory begin to work.");
        StorageDrive hdd = StorageFactory.createStorage("hdd");
        StorageDrive ssd = StorageFactory.createStorage("ssd");
        StorageDrive nvme = StorageFactory.createStorage("nvme");
        System.out.println(hdd.getSpecs());
        System.out.println(ssd.getSpecs());
        System.out.println(nvme.getSpecs());
        System.out.println("----------Factory end----------");
        System.out.println();

        System.out.println("----------Factory method begin----------");
        CaseManufacturer gamingManufacturer = new GamingCaseManufacturer();
        ComputerCase gamingCase = gamingManufacturer.manufactureCase();
        System.out.println(gamingManufacturer.getClass().getSimpleName() + " manufactured " + gamingCase.getCaseType());

        CaseManufacturer officeManufacturer = new OfficeCaseManufacturer();
        ComputerCase officeCase = officeManufacturer.manufactureCase();
        System.out.println(officeManufacturer.getClass().getSimpleName() + " manufactured " + officeCase.getCaseType());

        CaseManufacturer serverManufacturer = new ServerCaseManufacturer();
        ComputerCase serverCase = serverManufacturer.manufactureCase();
        System.out.println(serverManufacturer.getClass().getSimpleName() + " manufactured " + serverCase.getCaseType());
        System.out.println("----------Factory method end----------");
        System.out.println();

        System.out.println("----------Prototype begin----------");
        WindowsGamingImage originalImage = new WindowsGamingImage();
        WindowsGamingImage clonedImage = (WindowsGamingImage) originalImage.clone();

        if (originalImage != clonedImage) {
            System.out.println("Objects are not the same! Yeah!");
        }
        if (originalImage.equals(clonedImage)) {
            System.out.println("Objects are identical! Yeah!");
        }
        System.out.println("----------Prototype end----------");
        System.out.println();

        System.out.println("----------Singleton begin----------");
        SystemConfig configInstance1 = SystemConfig.getInstance();
        System.out.println(configInstance1.hashCode());
        System.out.println("Factory Region: " + configInstance1.getRegion());

        SystemConfig configInstance2 = SystemConfig.getInstance();
        System.out.println(configInstance2.hashCode());
        System.out.println("----------Singleton end----------");
        System.out.println();
    }
}