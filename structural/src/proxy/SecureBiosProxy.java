package proxy;

public class SecureBiosProxy implements BiosSettings {
    private RealBiosSettings realBios;
    private String adminPassword;

    public SecureBiosProxy(String password) {
        this.adminPassword = password;
    }

    @Override
    public void unlockOverclocking() {
        if ("admin123".equals(adminPassword)) {
            if (realBios == null) {
                realBios = new RealBiosSettings();
            }
            realBios.unlockOverclocking();
        } else {
            System.out.println("PROXY ПОМИЛКА: Невірний пароль! Доступ до розгону заборонено.");
        }
    }
}