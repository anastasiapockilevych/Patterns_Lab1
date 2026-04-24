package execute_around;
import java.util.function.Consumer;
import java.util.function.Function;

public class ExecuteAround {

    public record CaseContext(String caseType) {
        public void install(String component) {
            System.out.println("  [" + caseType + "] Встановлено: " + component);
        }
    }

    @FunctionalInterface
    public interface CaseAction<T> {
        T execute(CaseContext ctx) throws Exception;
    }

    public static <T> T withCase(String caseType, CaseAction<T> action) {
        System.out.println(">> Відкриваємо корпус: " + caseType);
        try {
            T result = action.execute(new CaseContext(caseType));
            System.out.println("<< Закриваємо корпус: " + caseType);
            return result;
        } catch (Exception e) {
            System.out.println("!! Помилка під час роботи з корпусом: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static <T> T timed(String label, CaseAction<T> action) {
        System.out.println("[Таймер] Початок: " + label);
        long start = System.nanoTime();
        try {
            T result = action.execute(new CaseContext("benchmark"));
            long elapsed = (System.nanoTime() - start) / 1_000_000;
            System.out.printf("[Таймер] Завершено: %s (%d мс)%n", label, elapsed);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static int indent = 0;

    public static void withLogging(String stepName, Runnable action) {
        System.out.println("  ".repeat(indent) + "▶ " + stepName);
        indent++;
        action.run();
        indent--;
        System.out.println("  ".repeat(indent) + "✔ " + stepName + " завершено");
    }


    public static void main(String[] args) {
        System.out.println("=== Execute Around: Встановлення компонентів ===");
        String result = withCase("RGB Gaming Mid-Tower", ctx -> {
            ctx.install("Материнська плата");
            ctx.install("Відеокарта RTX 4080");
            ctx.install("32 GB DDR5 RAM");
            return "Збірка завершена успішно";
        });
        System.out.println("Результат: " + result);

        System.out.println();
        System.out.println("=== Execute Around: Вимірювання часу ===");
        timed("Тест охолодження", ctx -> {
            Thread.sleep(50); // симуляція роботи
            System.out.println("  Охолодження протестовано");
            return null;
        });

        System.out.println();
        System.out.println("=== Execute Around: Логування кроків збірки ===");
        withLogging("Збірка ПК", () -> {
            withLogging("Встановлення охолодження", () ->
                    System.out.println("    Монтаж кулера"));
            withLogging("Встановлення накопичувача", () ->
                    System.out.println("    Підключення NVMe SSD"));
        });
    }
}