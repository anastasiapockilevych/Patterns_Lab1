package prototype;

import java.util.Objects;

public class WindowsGamingImage implements SystemImage {
    private String details;

    public WindowsGamingImage() {
        this.details = "Windows 11 Gaming Edition";
    }

    @Override
    public SystemImage clone() {
        try {
            return (SystemImage) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String getDetails() {
        return this.details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Якщо це один і той самий об'єкт у пам'яті
        if (o == null || getClass() != o.getClass()) return false; // Якщо класи різні
        WindowsGamingImage that = (WindowsGamingImage) o;
        return Objects.equals(details, that.details); // Порівнюємо саме поля
    }

    @Override
    public int hashCode() {
        return Objects.hash(details);
    }
}