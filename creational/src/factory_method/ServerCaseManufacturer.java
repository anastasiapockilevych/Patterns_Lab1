package factory_method;
public class ServerCaseManufacturer extends CaseManufacturer {
    public ComputerCase manufactureCase() { return new ServerCase(); }
}