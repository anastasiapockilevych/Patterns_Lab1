package visitor;

public interface HardwareVisitor {
    void visit(CpuPart cpu);
    void visit(GpuPart gpu);
}