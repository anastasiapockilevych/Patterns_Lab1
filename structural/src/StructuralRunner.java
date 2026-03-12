import adapter.*;
import bridge.*;
import composite.*;
import decorator.*;
import facade.*;
import flyweight.*;
import proxy.*;

public class StructuralRunner {
    public static void main(String[] args) {
        System.out.println("----------Adapter begin----------");
        VgaMonitor oldMonitor = new VgaMonitor();
        HdmiPort adapter = new VgaToHdmiAdapter(oldMonitor);
        adapter.displayDigital("Цифровий HD відеопотік");
        System.out.println("----------Adapter end----------\n");

        System.out.println("----------Bridge begin----------");
        ComputerSystem desktop = new DesktopPc(new WindowsOs());
        desktop.turnOn();
        System.out.println("----------Bridge end----------\n");

        System.out.println("----------Composite begin----------");
        MotherboardComposite motherboard = new MotherboardComposite("Материнська плата ASUS");
        motherboard.addComponent(new SimplePart("CPU Intel Core i5", 250));
        motherboard.addComponent(new SimplePart("RAM 16GB", 80));
        motherboard.showDetails();
        System.out.println("Загальна вартість вузла: $" + motherboard.getPrice());
        System.out.println("----------Composite end----------\n");

        System.out.println("----------Decorator begin----------");
        PcSetup myPc = new BasicPc();
        myPc = new RgbDecorator(myPc);
        System.out.println("Моя збірка: " + myPc.getDescription());
        System.out.println("Ціна: $" + myPc.getCost());
        System.out.println("----------Decorator end----------\n");

        System.out.println("----------Facade begin----------");
        ComputerFacade myComputer = new ComputerFacade();
        myComputer.pushPowerButton();
        System.out.println("----------Facade end----------\n");

        System.out.println("----------Flyweight begin----------");
        // Збираємо планку пам'яті на 4 чипи. Зверніть увагу: об'єкт RamChip створиться лише один раз!
        for (int i = 1; i <= 4; i++) {
            RamChip chip = RamChipFactory.getChip("Samsung", 3200);
            chip.render(i);
        }
        System.out.println("----------Flyweight end----------\n");

        System.out.println("----------Proxy begin----------");
        BiosSettings unauthorizedAccess = new SecureBiosProxy("wrong_pass");
        unauthorizedAccess.unlockOverclocking(); // Має видати помилку

        BiosSettings authorizedAccess = new SecureBiosProxy("admin123");
        authorizedAccess.unlockOverclocking(); // Має успішно пропустити
        System.out.println("----------Proxy end----------\n");
    }
}