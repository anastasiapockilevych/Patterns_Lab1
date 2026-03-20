package command;

public class TurnOnCommand implements Command {
    private PcSystem pc;
    public TurnOnCommand(PcSystem pc) { this.pc = pc; }
    public void execute() { pc.turnOn(); }
}