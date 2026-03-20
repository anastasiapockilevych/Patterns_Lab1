package chain_of_responsibility;

public class BiosHandler extends DiagnosticHandler {
    public void check(String issue) {
        if (issue.equals("No Boot Device")) System.out.println("BiosHandler: Перевірити підключення диска.");
        else if (next != null) next.check(issue);
    }
}