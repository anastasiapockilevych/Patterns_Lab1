package adapter;
public class VgaToHdmiAdapter implements HdmiPort {
    private VgaMonitor vgaMonitor;
    public VgaToHdmiAdapter(VgaMonitor vgaMonitor) {
        this.vgaMonitor = vgaMonitor;
    }
    @Override
    public void displayDigital(String digitalData) {
        String analogSignal = digitalData.replace("Цифровий", "Аналоговий");
        System.out.println("Адаптер: конвертую [" + digitalData + "] у [" + analogSignal + "]");
        vgaMonitor.showAnalog(analogSignal);
    }
}