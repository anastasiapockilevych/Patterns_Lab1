package strategy;

public class TurboMode implements CoolingStrategy {
    public void cool() { System.out.println("Охолодження: Вентилятори на 3000 RPM (Турбо)"); }
}