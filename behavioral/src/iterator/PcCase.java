package iterator;
import java.util.ArrayList;
import java.util.List;

public class PcCase {
    private List<String> fans = new ArrayList<>();
    public void addFan(String fan) { fans.add(fan); }

    public FanIterator getIterator() {
        return new FanIterator() {
            private int index = 0;
            public boolean hasNext() { return index < fans.size(); }
            public String next() { return fans.get(index++); }
        };
    }
}
