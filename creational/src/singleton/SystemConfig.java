package singleton;
public class SystemConfig {
    private static SystemConfig instance;
    private String factoryRegion = "Europe";
    private SystemConfig() {}
    public static synchronized SystemConfig getInstance() {
        if (instance == null) instance = new SystemConfig();
        return instance;
    }
    public String getRegion() { return factoryRegion; }
}