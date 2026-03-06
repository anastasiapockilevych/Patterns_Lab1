package prototype;

import java.util.Objects;

public class UbuntuServerImage implements SystemImage {
    private String details;

    public UbuntuServerImage() {
        this.details = "Ubuntu Server 24.04";
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UbuntuServerImage that = (UbuntuServerImage) o;
        return Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(details);
    }
}