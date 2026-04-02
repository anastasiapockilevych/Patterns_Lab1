import chain_of_responsibility.*;
import command.*;
import iterator.*;
import mediator.*;
import memento.*;
import state.*;
import strategy.*;
import template_method.*;
import visitor.*;
import observer.*;

public class BehavioralRunner {
    public static void main(String[] args) {
        System.out.println("----------Chain of Responsibility----------");
        DiagnosticHandler power = new PowerHandler();
        DiagnosticHandler bios = new BiosHandler();
        power.setNext(bios); // Зв'язуємо в ланцюг
        power.check("No Boot Device");

        System.out.println("\n----------Command----------");
        PcSystem myPc = new PcSystem();
        RemoteControl remote = new RemoteControl();
        remote.setCommand(new TurnOnCommand(myPc));
        remote.pressButton();

        System.out.println("\n----------Iterator----------");
        PcCase pcCase = new PcCase();
        pcCase.addFan("Front Fan 1");
        pcCase.addFan("Rear Fan");
        FanIterator iterator = pcCase.getIterator();
        while (iterator.hasNext()) {
            System.out.println("Знайдено вентилятор: " + iterator.next());
        }

        System.out.println("\n----------Mediator----------");
        Motherboard asus = new AsusMotherboard();
        Cpu cpu = new Cpu(asus);
        cpu.requestData();

        System.out.println("\n----------Memento----------");
        Bios uefi = new Bios();
        uefi.setProfile("Safe Mode");
        BiosMemento backup = uefi.save();
        uefi.setProfile("Extreme Overclock");
        uefi.show();
        uefi.restore(backup); // Відкат налаштувань
        uefi.show();

        System.out.println("\n----------State----------");
        Computer comp = new Computer();
        comp.setState(new OffState());
        comp.pressButton();
        comp.setState(new SleepState());
        comp.pressButton();

        System.out.println("\n----------Strategy----------");
        FanController fanCtrl = new FanController();
        fanCtrl.setStrategy(new SilentMode());
        fanCtrl.applyCooling();
        fanCtrl.setStrategy(new TurboMode());
        fanCtrl.applyCooling();

        System.out.println("\n----------Template Method----------");
        OsInstaller winSetup = new WindowsInstaller();
        winSetup.install();
        OsInstaller linuxSetup = new LinuxInstaller();
        linuxSetup.install();

        System.out.println("\n----------Observer----------");
        CpuSensor sensor = new CpuSensor();
        Observer fan = new CoolingFan();
        Observer display = new DisplayWidget();

        sensor.addObserver(fan);
        sensor.addObserver(display);

        sensor.setTemperature(45);
        sensor.setTemperature(85);

        System.out.println("----------Visitor----------");
        PcPart[] parts = {new CpuPart(), new GpuPart()};
        BenchmarkVisitor benchmark = new BenchmarkVisitor();
        for (PcPart part : parts) {
            part.accept(benchmark);
        }
    }
}