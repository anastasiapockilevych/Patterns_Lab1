import abstract_factory.*;
import builder.*;
import factory.*;
import factory_method.*;
import prototype.*;
import singleton.*;

public class CreationalRunner {

    public static void main(String[] args) { run(); }

    public static void run() {
        System.out.println("----------Abstract factory begin---------");
        PlatformFactory intelFactory = new IntelFactory();
        System.out.println("Intel CPU: " + intelFactory.createCpu().getCpuName());
        System.out.println("Intel Motherboard: " + intelFactory.createMotherboard().getBoardName());

        PlatformFactory amdFactory = new AmdFactory();
        System.out.println("AMD CPU: " + amdFactory.createCpu().getCpuName());
        System.out.println("AMD Motherboard: " + amdFactory.createMotherboard().getBoardName());
        System.out.println("-----------Abstract factory end----------");
        System.out.println();

        System.out.println("----------Builder begin---------");
        ComputerDirector director = new ComputerDirector();

        // ВИПРАВЛЕННЯ: Використовуємо ConcretePcBuilder замість інтерфейсу
        ConcretePcBuilder pcBuilder = new ConcretePcBuilder();

        director.constructGamingPc(pcBuilder, "SN-GAMER-123");
        Computer gamingPc = pcBuilder.getResult();
        gamingPc.showSpecs();

        // Створюємо сервер за допомогою того ж самого будівельника (після reset)
        director.constructServerPc(pcBuilder, "SN-SERVER-456");
        Computer serverPc = pcBuilder.getResult();
        serverPc.showSpecs();
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
        SystemImage windowsImage = new WindowsGamingImage();
        SystemImage clonedWindows = windowsImage.clone();

        if (windowsImage != clonedWindows) {
            System.out.println("Objects are not the same! Yeah!");
        }
        if (windowsImage.getClass().equals(clonedWindows.getClass())) {
            System.out.println("Objects are identical classes! Yeah! Details: " + clonedWindows.getDetails());
        }
        System.out.println("----------Prototype end----------");
        System.out.println();

        System.out.println("----------Singleton begin----------");
        SystemConfig configInstance1 = SystemConfig.getInstance();
        System.out.println(configInstance1.hashCode());
        System.out.println("Factory Region: " + configInstance1.getRegion());

        SystemConfig configInstance2 = SystemConfig.getInstance();
        System.out.println(configInstance2.hashCode());

        if (configInstance1 == configInstance2) {
            System.out.println("Both configurations point to the same instance!");
        }
        System.out.println("----------Singleton end----------");
        System.out.println();
    }
}