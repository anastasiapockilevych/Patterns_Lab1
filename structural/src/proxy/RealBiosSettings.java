package proxy;

public class RealBiosSettings implements BiosSettings {
    @Override
    public void unlockOverclocking() {
        System.out.println("BIOS: Розгін процесора (Overclocking) УВІМКНЕНО! Увага, слідкуйте за температурою!");
    }
}