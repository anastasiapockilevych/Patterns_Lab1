package flyweight;

import java.util.HashMap;
import java.util.Map;

public class RamChipFactory {
    private static final Map<String, RamChip> chips = new HashMap<>();

    public static RamChip getChip(String manufacturer, int speedMHz) {
        String key = manufacturer + "_" + speedMHz;
        if (!chips.containsKey(key)) {
            chips.put(key, new RamChip(manufacturer, speedMHz));
        }
        return chips.get(key);
    }
}