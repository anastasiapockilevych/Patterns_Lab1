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