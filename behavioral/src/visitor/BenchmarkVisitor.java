package visitor;

public class BenchmarkVisitor implements HardwareVisitor {
    public void visit(CpuPart cpu) { System.out.println("Тестую процесор: " + cpu.getInfo()); }
    public void visit(GpuPart gpu) { System.out.println("Рендерю 3D на: " + gpu.getInfo()); }
}
