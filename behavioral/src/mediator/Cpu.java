package mediator;

public class Cpu {
    private Motherboard mediator;
    public Cpu(Motherboard mediator) { this.mediator = mediator; }
    public void requestData() { mediator.notify("CPU", "ReadData"); }
}
