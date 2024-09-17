public class HouseFactory {
    public static House createHouse(String houseType) throws InvalidHouseDataException {
        switch (houseType.trim().toUpperCase()) {
            case "RESIDENTIALHOUSE":
                return new ResidentialHouse();
            case "SHOP":
                return new Shop();
            case "SCHOOL":
                return new School();
            case "HOSPITAL":
                return new Hospital();
            default:
                throw new InvalidHouseDataException("Invalid house type: " + houseType);
        }
    }
}
