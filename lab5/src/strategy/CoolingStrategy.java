package strategy;

@FunctionalInterface
public interface CoolingStrategy {
    void cool();

    // Фабричні методи-константи (замінюють окремі класи SilentMode, TurboMode)
    static CoolingStrategy silent() {
        return () -> System.out.println("Охолодження: Вентилятори на 300 RPM (Тихо)");
    }

    static CoolingStrategy turbo() {
        return () -> System.out.println("Охолодження: Вентилятори на 3000 RPM (Турбо)");
    }

    static CoolingStrategy custom(int rpm, String label) {
        return () -> System.out.printf("Охолодження: Вентилятори на %d RPM (%s)%n", rpm, label);
    }
}