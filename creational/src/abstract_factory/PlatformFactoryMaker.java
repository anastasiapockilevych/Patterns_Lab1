package abstract_factory;

public class PlatformFactoryMaker {

    public static PlatformFactory makeFactory(PlatformType type) {
        switch (type) {
            case INTEL:
                return new IntelFactory();
            case AMD:
                return new AmdFactory();
            default:
                throw new IllegalArgumentException("Невідомий тип платформи: " + type);
        }
    }
}