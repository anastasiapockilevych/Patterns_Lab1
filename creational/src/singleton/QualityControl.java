package singleton;
public class QualityControl {
    private static QualityControl instance;
    private QualityControl() {}
    public static synchronized QualityControl getInstance() {
        if (instance == null) instance = new QualityControl();
        return instance;
    }
    public boolean passInspection() { return true; } // Завжди успішно для демо
}
