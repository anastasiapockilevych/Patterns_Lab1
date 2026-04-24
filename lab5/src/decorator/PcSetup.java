package decorator;

import java.util.function.Function;
import java.util.function.UnaryOperator;


public class PcSetup {

    public record Pc(String description, int cost) {}

    public static final UnaryOperator<Pc> withRgb =
            pc -> new Pc(pc.description() + " + RGB підсвітка", pc.cost() + 50);

    public static final UnaryOperator<Pc> withWaterCooling =
            pc -> new Pc(pc.description() + " + Рідинне охолодження", pc.cost() + 150);

    public static final UnaryOperator<Pc> withSsdUpgrade =
            pc -> new Pc(pc.description() + " + NVMe SSD", pc.cost() + 100);

    @SafeVarargs
    public static Pc decorate(Pc base, UnaryOperator<Pc>... decorators) {
        Function<Pc, Pc> pipeline = Function.identity();
        for (UnaryOperator<Pc> decorator : decorators) {
            pipeline = pipeline.andThen(decorator);
        }
        return pipeline.apply(base);
    }

    public static void main(String[] args) {
        Pc base = new Pc("Базовий ПК", 500);

        Pc withOnlyRgb = withRgb.apply(base);
        System.out.println(withOnlyRgb.description() + " | Ціна: $" + withOnlyRgb.cost());

        Pc fullSetup = decorate(base, withRgb, withWaterCooling, withSsdUpgrade);
        System.out.println(fullSetup.description() + " | Ціна: $" + fullSetup.cost());

        boolean userWantsRgb   = true;
        boolean userWantsCooling = false;

        UnaryOperator<Pc> pipeline = UnaryOperator.identity();
        if (userWantsRgb)     pipeline = pipeline.andThen(withRgb)::apply;
        if (userWantsCooling) pipeline = pipeline.andThen(withWaterCooling)::apply;

        Pc custom = pipeline.apply(base);
        System.out.println(custom.description() + " | Ціна: $" + custom.cost());
    }
}