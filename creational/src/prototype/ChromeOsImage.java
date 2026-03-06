package prototype;
public class ChromeOsImage implements SystemImage {
    public SystemImage clone() {
        try { return (SystemImage) super.clone(); }
        catch (CloneNotSupportedException e) { return null; }
    }
    public String getDetails() { return "ChromeOS Flex (Cloud & Web Apps)"; }
}