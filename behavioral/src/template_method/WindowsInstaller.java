package template_method;

public class WindowsInstaller extends OsInstaller {
    protected void copyFiles() { System.out.print("Копіюю файли Windows... "); }
}