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