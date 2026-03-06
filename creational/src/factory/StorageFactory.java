package factory;
public class StorageFactory {
    public static StorageDrive createStorage(String type) {
        switch (type.toLowerCase()) {
            case "hdd": return new HddDrive();
            case "ssd": return new SataSsdDrive();
            case "nvme": return new NvmeDrive();
            case "external": return new ExternalUsbDrive();
            default: throw new IllegalArgumentException("Unknown storage type");
        }
    }
}