package chain_of_responsibility;

public class PowerHandler extends DiagnosticHandler {
    public void check(String issue) {
        if (issue.equals("No Power")) System.out.println("PowerHandler: Замінити блок живлення.");
        else if (next != null) next.check(issue);
    }
}