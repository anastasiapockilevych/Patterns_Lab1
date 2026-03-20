package state;

public class Computer {
    private PcState state;
    public void setState(PcState state) { this.state = state; }
    public void pressButton() { state.pressPowerButton(); }
}
