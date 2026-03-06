// --- File: singleton/SystemConfig.java ---
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

// --- File: singleton/InventoryManager.java ---
package singleton;
public class InventoryManager {
    private static InventoryManager instance;
    private int totalPartsUsed = 0;
    private InventoryManager() {}
    public static synchronized InventoryManager getInstance() {
        if (instance == null) instance = new InventoryManager();
        return instance;
    }
    public void consumeParts(int count) { totalPartsUsed += count; }
    public int getUsedParts() { return totalPartsUsed; }
}

// --- File: singleton/SerialNumberGenerator.java ---
package singleton;
import java.util.UUID;
public class SerialNumberGenerator {
    private static SerialNumberGenerator instance;
    private SerialNumberGenerator() {}
    public static synchronized SerialNumberGenerator getInstance() {
        if (instance == null) instance = new SerialNumberGenerator();
        return instance;
    }
    public String generate() { return "PC-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase(); }
}

// --- File: singleton/QualityControl.java ---
package singleton;
public class QualityControl {
    private static QualityControl instance;
    private QualityControl() {}
    public static synchronized QualityControl getInstance() {
        if (instance == null) instance = new QualityControl();
        return instance;
    }
    public boolean passInspection() { return true; } // Завжди успішно для демо
}

// --- File: singleton/AssemblyLogger.java ---
package singleton;
public class AssemblyLogger {
    private static AssemblyLogger instance;
    private AssemblyLogger() {}
    public static synchronized AssemblyLogger getInstance() {
        if (instance == null) instance = new AssemblyLogger();
        return instance;
    }
    public void log(String message) { System.out.println("[LOGGER] " + message); }
}