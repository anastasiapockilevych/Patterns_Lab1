package observer;

public class CoolingFan implements Observer {
    @Override
    public void update(int temperature) {
        if (temperature > 70) {
            System.out.println("  -> Вентилятор: УВАГА! Гаряче! Вмикаю максимальні оберти!");
        } else {
            System.out.println("  -> Вентилятор: Температура в нормі. Кручусь тихо.");
        }
    }
}