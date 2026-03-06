package factory_method;
public class GamingCaseManufacturer extends CaseManufacturer {
    public ComputerCase manufactureCase() { return new GamingCase(); }
}