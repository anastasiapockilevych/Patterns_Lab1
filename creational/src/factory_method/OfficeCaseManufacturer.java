package factory_method;
public class OfficeCaseManufacturer extends CaseManufacturer {
    public ComputerCase manufactureCase() { return new OfficeCase(); }
}