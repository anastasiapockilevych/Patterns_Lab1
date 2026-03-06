package prototype;
public class UbuntuServerImage implements SystemImage {
    public SystemImage clone() {
        try { return (SystemImage) super.clone(); }
        catch (CloneNotSupportedException e) { return null; }
    }
    public String getDetails() { return "Ubuntu Server 24.04 (Pre-installed: Docker, Nginx)"; }
}
