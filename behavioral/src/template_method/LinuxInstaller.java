package template_method;

public class LinuxInstaller extends OsInstaller {
    protected void copyFiles() { System.out.print("Розпаковую ядро Linux... "); }
}
