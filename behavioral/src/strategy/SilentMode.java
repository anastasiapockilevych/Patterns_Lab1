package strategy;

public class SilentMode implements CoolingStrategy {
    public void cool() { System.out.println("Охолодження: Вентилятори на 300 RPM (Тихо)"); }
}
