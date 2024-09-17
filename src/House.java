public interface House {
    String getAddress();
    void setAddress(String address);

    void setFieldsFromString(String data) throws InvalidHouseDataException;

    void displayInfo();
}
