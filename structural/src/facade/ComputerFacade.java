package facade;
public class ComputerFacade {
    private PowerSupply psu = new PowerSupply();
    private Bios bios = new Bios();

    public void pushPowerButton() {
        System.out.println("--- Натиснуто кнопку увімкнення ---");
        psu.turnOn();
        bios.checkHardware();
        System.out.println("Комп'ютер готовий до роботи!");
    }
}