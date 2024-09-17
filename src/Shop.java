import java.util.ArrayList;
import java.util.List;

public class Shop implements House {
    private String address;
    private ShopType shopType;
    private List<DepartmentType> departments;

    public Shop(String address, ShopType shopType, List<DepartmentType> departments) {
        this.address = address;
        this.shopType = shopType;
        this.departments = departments;
    }

    public Shop() {
        // Empty constructor
        departments = new ArrayList<>();
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    public ShopType getShopType() {
        return shopType;
    }

    public void setShopType(ShopType shopType) {
        this.shopType = shopType;
    }

    public List<DepartmentType> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentType> departments) {
        this.departments = departments;
    }

    @Override
    public void setFieldsFromString(String data) throws InvalidHouseDataException {
        String[] tokens = data.split(";");
        try {
            if (tokens.length != 3) {
                throw new InvalidHouseDataException("Shop data must have 3 fields: address;shopType;departments");
            }
            setAddress(tokens[0]);
            setShopType(ShopType.valueOf(tokens[1].trim().toUpperCase()));
            String[] deptTokens = tokens[2].split(",");
            departments = new ArrayList<>();
            for (String dept : deptTokens) {
                departments.add(DepartmentType.valueOf(dept.trim().toUpperCase()));
            }
        } catch (IllegalArgumentException e) {
            throw new InvalidHouseDataException("Invalid shop type or department type.", e);
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Shop at " + address + " of type " + shopType + " with departments: " + departments);
    }
}
