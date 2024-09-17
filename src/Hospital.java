public class Hospital implements House {
    private String address;
    private int capacity;

    public Hospital(String address, int capacity) {
        this.address = address;
        this.capacity = capacity;
    }

    public Hospital() {
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void setFieldsFromString(String data) throws InvalidHouseDataException {
        String[] tokens = data.split(";");
        try {
            if (tokens.length != 2) {
                throw new InvalidHouseDataException("Hospital data must have 2 fields: address;capacity");
            }
            setAddress(tokens[0]);
            setCapacity(Integer.parseInt(tokens[1]));
        } catch (NumberFormatException e) {
            throw new InvalidHouseDataException("Capacity must be an integer.", e);
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Hospital at " + address + " with capacity " + capacity);
    }
}
