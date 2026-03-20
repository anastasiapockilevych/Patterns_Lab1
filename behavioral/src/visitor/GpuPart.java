package visitor;

public class GpuPart implements PcPart {
    public void accept(HardwareVisitor visitor) { visitor.visit(this); }
    public String getInfo() { return "NVIDIA RTX 4070"; }
}