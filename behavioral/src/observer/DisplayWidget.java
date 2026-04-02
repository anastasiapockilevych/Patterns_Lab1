package observer;

public class DisplayWidget implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("  -> Віджет на екрані: Поточна температура процесора " + temperature + "°C");
    }
}