import strategy.CoolingStrategy;
import strategy.FanController;
import factory_method.CaseFactory;
import decorator.PcSetup;
import decorator.PcSetup.Pc;
import execute_around.ExecuteAround;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Патерн Стратегія (Functional)");
        FanController controller = new FanController();
        controller.applyCooling(CoolingStrategy.silent());
        controller.applyCooling(CoolingStrategy.turbo());
        controller.applyCooling(CoolingStrategy.custom(1200, "Збалансовано"));
        controller.applyCooling(() -> System.out.println("Охолодження: авто-режим"));

        System.out.println();
        System.out.println("2. Фабричний метод (Functional)");

        CaseFactory.create("gaming")
                .ifPresent(c -> System.out.println("Вироблено: " + c.getCaseType()));
        CaseFactory.create("office")
                .ifPresent(c -> System.out.println("Вироблено: " + c.getCaseType()));
        CaseFactory.create("server")
                .ifPresent(c -> System.out.println("Вироблено: " + c.getCaseType()));
        CaseFactory.create("unknown")
                .ifPresentOrElse(
                        c -> System.out.println("Вироблено: " + c.getCaseType()),
                        () -> System.out.println("Невідомий тип корпуса")
                );

        System.out.println();
        System.out.println("3. Декоратор (Functional)");

        Pc base = new Pc("Базовий ПК", 500);

        Pc rgbOnly = PcSetup.withRgb.apply(base);
        System.out.println(rgbOnly.description() + " | $" + rgbOnly.cost());

        Pc fullBuild = PcSetup.decorate(base,
                PcSetup.withRgb,
                PcSetup.withWaterCooling,
                PcSetup.withSsdUpgrade);
        System.out.println(fullBuild.description() + " | $" + fullBuild.cost());

        System.out.println();
        System.out.println("4. Execute Around");

        ExecuteAround.withCase("RGB Gaming Mid-Tower", ctx -> {
            ctx.install("Материнська плата");
            ctx.install("GPU RTX 4080");
            return "OK";
        });

        System.out.println();
        ExecuteAround.withLogging("Збірка ПК", () -> {
            ExecuteAround.withLogging("Встановлення охолодження",
                    () -> System.out.println("Монтаж кулера"));
            ExecuteAround.withLogging("Встановлення SSD",
                    () -> System.out.println("Підключення NVMe"));
        });
    }
}