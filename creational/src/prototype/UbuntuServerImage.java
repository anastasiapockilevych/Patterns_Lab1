
// --- File: prototype/UbuntuServerImage.java ---
package prototype;
public class UbuntuServerImage implements SystemImage {
    public SystemImage clone() {
        try { return (SystemImage) super.clone(); }
        catch (CloneNotSupportedException e) { return null; }
    }
    public String getDetails() { return "Ubuntu Server 24.04 (Pre-installed: Docker, Nginx)"; }
}

// --- File: prototype/MacOSCreativeImage.java ---
package prototype;
public class MacOSCreativeImage implements SystemImage {
    public SystemImage clone() {
        try { return (SystemImage) super.clone(); }
        catch (CloneNotSupportedException e) { return null; }
    }
    public String getDetails() { return "macOS Sonoma (Pre-installed: Final Cut, Logic Pro)"; }
}

// --- File: prototype/SteamOsImage.java ---
package prototype;
public class SteamOsImage implements SystemImage {
    public SystemImage clone() {
        try { return (SystemImage) super.clone(); }
        catch (CloneNotSupportedException e) { return null; }
    }
    public String getDetails() { return "SteamOS 3.0 (Console Mode Optimized)"; }
}

// --- File: prototype/ChromeOsImage.java ---
package prototype;
public class ChromeOsImage implements SystemImage {
    public SystemImage clone() {
        try { return (SystemImage) super.clone(); }
        catch (CloneNotSupportedException e) { return null; }
    }
    public String getDetails() { return "ChromeOS Flex (Cloud & Web Apps)"; }
}