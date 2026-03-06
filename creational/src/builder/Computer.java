package builder;
import factory.StorageDrive;
import prototype.SystemImage;
import abstract_factory.Cpu;
import abstract_factory.Motherboard;
import factory_method.ComputerCase;

public class Computer {
    public String serialNumber;
    public ComputerCase pcCase;
    public Cpu cpu;
    public Motherboard motherboard;
    public StorageDrive storage;
    public SystemImage osImage;

    public void showSpecs() {
        System.out.println("\n=== PC [" + serialNumber + "] ===");
        System.out.println("Case  : " + (pcCase != null ? pcCase.getCaseType() : "N/A"));
        System.out.println("CPU   : " + (cpu != null ? cpu.getCpuName() : "N/A"));
        System.out.println("Mobo  : " + (motherboard != null ? motherboard.getBoardName() : "N/A"));
        System.out.println("Drive : " + (storage != null ? storage.getSpecs() : "N/A"));
        System.out.println("OS    : " + (osImage != null ? osImage.getDetails() : "N/A"));
        System.out.println("===========================");
    }
}