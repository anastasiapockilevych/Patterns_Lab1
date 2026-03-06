package prototype;
public class MacOSCreativeImage implements SystemImage {
    public SystemImage clone() {
        try { return (SystemImage) super.clone(); }
        catch (CloneNotSupportedException e) { return null; }
    }
    public String getDetails() { return "macOS Sonoma (Pre-installed: Final Cut, Logic Pro)"; }
}