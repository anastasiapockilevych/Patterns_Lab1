package chain_of_responsibility;

public abstract class DiagnosticHandler {
    protected DiagnosticHandler next;
    public void setNext(DiagnosticHandler next) { this.next = next; }
    public abstract void check(String issue);
}