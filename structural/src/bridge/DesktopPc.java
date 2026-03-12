package bridge;
public class DesktopPc extends ComputerSystem {
    public DesktopPc(OperatingSystem os) { super(os); }
    public void turnOn() {
        System.out.print("Десктопний ПК увімкнено. ");
        os.bootOs();
    }
}