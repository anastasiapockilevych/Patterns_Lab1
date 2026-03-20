package visitor;

public class CpuPart implements PcPart {
    public void accept(HardwareVisitor visitor) { visitor.visit(this); }
    public String getInfo() { return "Intel Core i7"; }
}
