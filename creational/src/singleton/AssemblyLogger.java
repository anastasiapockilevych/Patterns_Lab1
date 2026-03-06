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