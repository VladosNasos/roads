public class ResidentialHouse implements House {
    private String address;
    private int numberOfResidents;

    public ResidentialHouse(String address, int numberOfResidents) {
        this.address = address;
        this.numberOfResidents = numberOfResidents;
    }

    public ResidentialHouse() {
        // Empty constructor
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfResidents() {
        return numberOfResidents;
    }

    public void setNumberOfResidents(int numberOfResidents) {
        this.numberOfResidents = numberOfResidents;
    }

    @Override
    public void setFieldsFromString(String data) throws InvalidHouseDataException {
        String[] tokens = data.split(";");
        try {
            if (tokens.length != 2) {
                throw new InvalidHouseDataException("ResidentialHouse data must have 2 fields: address;numberOfResidents");
            }
            setAddress(tokens[0]);
            setNumberOfResidents(Integer.parseInt(tokens[1]));
        } catch (NumberFormatException e) {
            throw new InvalidHouseDataException("Number of residents must be an integer.", e);
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Residential House at " + address + " with " + numberOfResidents + " residents.");
    }
}
