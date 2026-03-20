package template_method;

public abstract class OsInstaller {
    public final void install() {
        formatDisk();
        copyFiles();
        System.out.println("Готово!\n");
    }
    private void formatDisk() { System.out.print("Форматую диск... "); }
    protected abstract void copyFiles();
}