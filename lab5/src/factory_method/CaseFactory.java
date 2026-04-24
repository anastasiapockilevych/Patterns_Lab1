package factory_method;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class CaseFactory {

    private static final Map<String, Supplier<ComputerCase>> REGISTRY = Map.of(
            "gaming",  GamingCase::new,
            "office",  OfficeCase::new,
            "server",  ServerCase::new
    );

    public static Optional<ComputerCase> create(String type) {
        return Optional.ofNullable(REGISTRY.get(type.toLowerCase()))
                .map(Supplier::get);
    }

    public static void main(String[] args) {
        CaseFactory.create("gaming")
                .ifPresent(c -> System.out.println("Вироблено: " + c.getCaseType()));

        CaseFactory.create("office")
                .ifPresent(c -> System.out.println("Вироблено: " + c.getCaseType()));

        CaseFactory.create("server")
                .ifPresent(c -> System.out.println("Вироблено: " + c.getCaseType()));

        // Невідомий тип
        CaseFactory.create("unknown")
                .ifPresentOrElse(
                        c -> System.out.println("Вироблено: " + c.getCaseType()),
                        () -> System.out.println("Невідомий тип корпуса")
                );
    }
}