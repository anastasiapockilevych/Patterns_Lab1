package builder;

import abstract_factory.Cpu;
import abstract_factory.Motherboard;
import factory.StorageDrive;
import factory_method.ComputerCase;
import prototype.SystemImage;

public class Computer {
    public String serialNumber;
    public Cpu cpu;
    public Motherboard motherboard;
    public ComputerCase pcCase;
    public StorageDrive storage;
    public SystemImage osImage;

    @Override
    public String toString() {
        return "ПК Серійний номер: " + serialNumber + "\n" +
                " - Процесор: " + (cpu != null ? cpu.getCpuName() : "Немає") + "\n" +
                " - Материнка: " + (motherboard != null ? motherboard.getBoardName() : "Немає") + "\n" +
                " - Корпус: " + (pcCase != null ? pcCase.getCaseType() : "Немає") + "\n" +
                " - Накопичувач: " + (storage != null ? storage.getSpecs() : "Немає") + "\n" +
                " - ОС: " + (osImage != null ? osImage.getDetails() : "Немає");
    }
}