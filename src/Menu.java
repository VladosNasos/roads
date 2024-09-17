import java.util.Scanner;

public class Menu {
    private Street street;
    private Scanner scanner;

    public Menu(Street street) {
        this.street = street;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() throws InvalidHouseDataException {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\nStreet Management Menu:");
            System.out.println("1. Display street information");
            System.out.println("2. Add a new house");
            System.out.println("3. Remove a house");
            System.out.println("4. Find shops near a residential house");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    street.displayStreetInfo();
                    break;
                case 2:
                    addNewHouse();
                    break;
                case 3:
                    removeHouse();
                    break;
                case 4:
                    findShopsNearHouse();
                    break;
                case 0:
                    System.out.println("Exiting menu.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addNewHouse() throws InvalidHouseDataException {
        System.out.println("Select type of house to add:");
        System.out.println("1. Residential House");
        System.out.println("2. Shop");
        System.out.println("3. School");
        System.out.println("4. Hospital");
        System.out.print("Enter your choice: ");
        int houseType;
        try {
            houseType = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input.");
            return;
        }

        House house = null;
        switch (houseType) {
            case 1:
                house = new ResidentialHouse();
                break;
            case 2:
                house = new Shop();
                break;
            case 3:
                house = new School();
                break;
            case 4:
                house = new Hospital();
                break;
            default:
                System.out.println("Invalid house type.");
                return;
        }

        System.out.println("Enter data string for the house (format depends on house type):");
        System.out.println("For ResidentialHouse: address;numberOfResidents");
        System.out.println("For Shop: address;shopType;department1,department2,...");
        System.out.println("For School: address;accreditationLevel");
        System.out.println("For Hospital: address;capacity");
        String data = scanner.nextLine();
        house.setFieldsFromString(data);
        street.addHouse(house);
        System.out.println("House added.");
    }

    private void removeHouse() {
        System.out.println("Enter address of the house to remove:");
        String address = scanner.nextLine();
        House houseToRemove = null;
        for (House house : street.getHouses()) {
            if (house.getAddress().equals(address)) {
                houseToRemove = house;
                break;
            }
        }
        if (houseToRemove != null) {
            street.removeHouse(houseToRemove);
            System.out.println("House removed.");
        } else {
            System.out.println("House not found.");
        }
    }

    private void findShopsNearHouse() {
        System.out.println("Enter address of the residential house:");
        String address = scanner.nextLine();
        ResidentialHouse residentialHouse = null;
        for (House house : street.getHouses()) {
            if (house instanceof ResidentialHouse && house.getAddress().equals(address)) {
                residentialHouse = (ResidentialHouse) house;
                break;
            }
        }
        if (residentialHouse == null) {
            System.out.println("Residential house not found on the street.");
            return;
        }

        System.out.print("Enter neighborhood range (number of houses): ");
        int range;
        try {
            range = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input.");
            return;
        }

        System.out.print("Enter department type to search for (e.g., GROCERY, ELECTRONICS): ");
        String deptStr = scanner.nextLine();
        DepartmentType departmentType;
        try {
            departmentType = DepartmentType.valueOf(deptStr.trim().toUpperCase());
        } catch (Exception e) {
            System.out.println("Invalid department type.");
            return;
        }

        street.findShopsNearHouse(residentialHouse, range, departmentType);
    }
}
