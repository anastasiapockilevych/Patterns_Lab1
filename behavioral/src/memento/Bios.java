package memento;

public class Bios {
    private String currentProfile;
    public void setProfile(String profile) { this.currentProfile = profile; }
    public void show() { System.out.println("BIOS зараз: " + currentProfile); }
    public BiosMemento save() { return new BiosMemento(currentProfile); }
    public void restore(BiosMemento memento) { this.currentProfile = memento.getProfile(); }
}
