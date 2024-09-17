import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestFactory {
    public static Street createTestStreet() {
        Street street = new Street();

        // Create some houses
        ResidentialHouse house1 = new ResidentialHouse("1 Main St", 5);
        ResidentialHouse house2 = new ResidentialHouse("2 Main St", 10);

        Shop shop1 = new Shop("3 Main St", ShopType.PRIVATE_SMALL_SHOP,
                Arrays.asList(DepartmentType.GROCERY));
        Shop shop2 = new Shop("4 Main St", ShopType.SUPERMARKET,
                Arrays.asList(DepartmentType.values()));

        School school1 = new School("5 Main St", AccreditationLevel.COMPREHENSIVE);

        Hospital hospital1 = new Hospital("6 Main St", 100);

        // Add houses to street
        street.addHouse(house1);
        street.addHouse(house2);
        street.addHouse(shop1);
        street.addHouse(shop2);
        street.addHouse(school1);
        street.addHouse(hospital1);

        return street;
    }

    public static House createRandomHouse() throws InvalidHouseDataException {
        Random rand = new Random();
        int houseType = rand.nextInt(4); // 0 - Residential, 1 - Shop, 2 - School, 3 - Hospital

        switch (houseType) {
            case 0:
                return new ResidentialHouse("Random Residential", rand.nextInt(100) + 1);
            case 1:
                ShopType shopType = rand.nextBoolean() ? ShopType.PRIVATE_SMALL_SHOP : ShopType.SUPERMARKET;
                List<DepartmentType> departments = new ArrayList<>();
                if (shopType == ShopType.PRIVATE_SMALL_SHOP) {
                    departments.add(DepartmentType.GROCERY);
                } else {
                    departments.addAll(Arrays.asList(DepartmentType.values()));
                }
                return new Shop("Random Shop", shopType, departments);
            case 2:
                AccreditationLevel level = AccreditationLevel.values()[rand.nextInt(AccreditationLevel.values().length)];
                return new School("Random School", level);
            case 3:
                return new Hospital("Random Hospital", rand.nextInt(500) + 50);
            default:
                throw new InvalidHouseDataException("Invalid house type generated.");
        }
    }
}
