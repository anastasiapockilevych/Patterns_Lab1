package prototype;
public class WindowsGamingImage implements SystemImage {
    public SystemImage clone() {
        try { return (SystemImage) super.clone(); }
        catch (CloneNotSupportedException e) { return null; }
    }
    public String getDetails() { return "Windows 11 Gaming Edition (Pre-installed: Steam, Discord)"; }
}
