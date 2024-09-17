import java.util.ArrayList;
import java.util.List;

public class Street {
    private List<House> houses;

    public Street() {
        houses = new ArrayList<>();
    }

    public void addHouse(House house) {
        houses.add(house);
    }

    public void removeHouse(House house) {
        houses.remove(house);
    }

    public List<House> getHouses() {
        return houses;
    }

    public void displayStreetInfo() {
        System.out.println("Street has the following houses:");
        for (House house : houses) {
            house.displayInfo();
        }
    }

    public void findShopsNearHouse(ResidentialHouse residentialHouse, int neighborhoodRange, DepartmentType departmentType) {
        int houseIndex = houses.indexOf(residentialHouse);
        if (houseIndex == -1) {
            System.out.println("Residential house not found on the street.");
            return;
        }

        int start = Math.max(0, houseIndex - neighborhoodRange);
        int end = Math.min(houses.size() - 1, houseIndex + neighborhoodRange);

        System.out.println("Shops near " + residentialHouse.getAddress() + " with department " + departmentType + ":");
        boolean found = false;
        for (int i = start; i <= end; i++) {
            House house = houses.get(i);
            if (house instanceof Shop) {
                Shop shop = (Shop) house;
                if (shop.getDepartments().contains(departmentType)) {
                    shop.displayInfo();
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No shops found in the specified range with the specified department.");
        }
    }

    public ResidentialHouse getResidentialHouseByAddress(String address) throws HouseNotFoundException {
        for (House house : houses) {
            if (house instanceof ResidentialHouse && house.getAddress().equals(address)) {
                return (ResidentialHouse) house;
            }
        }
        throw new HouseNotFoundException("Residential house with address " + address + " not found.");
    }

    public House getHouseByAddress(String address) throws HouseNotFoundException {
        for (House house : houses) {
            if (house.getAddress().equals(address)) {
                return house;
            }
        }
        throw new HouseNotFoundException("House with address " + address + " not found.");
    }
}
