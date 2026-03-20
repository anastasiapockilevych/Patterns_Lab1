package command;

public class RemoteControl {
    private Command button;
    public void setCommand(Command command) { this.button = command; }
    public void pressButton() { button.execute(); }
}
