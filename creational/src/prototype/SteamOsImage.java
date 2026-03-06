package prototype;
public class SteamOsImage implements SystemImage {
    public SystemImage clone() {
        try { return (SystemImage) super.clone(); }
        catch (CloneNotSupportedException e) { return null; }
    }
    public String getDetails() { return "SteamOS 3.0 (Console Mode Optimized)"; }
}