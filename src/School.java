import java.util.Random;

public class School implements House {
    private String address;
    private AccreditationLevel accreditationLevel;
    private int numberOfStudents;

    public School(String address, AccreditationLevel accreditationLevel) {
        this.address = address;
        this.accreditationLevel = accreditationLevel;
        this.numberOfStudents = generateNumberOfStudents();
    }

    public School() {
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

    public AccreditationLevel getAccreditationLevel() {
        return accreditationLevel;
    }

    public void setAccreditationLevel(AccreditationLevel accreditationLevel) {
        this.accreditationLevel = accreditationLevel;
        this.numberOfStudents = generateNumberOfStudents();
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    private int generateNumberOfStudents() {
        Random rand = new Random();
        switch (accreditationLevel) {
            case COMPREHENSIVE:
                return rand.nextInt(300) + 200; // 200-499
            case GYMNASIUM:
                return rand.nextInt(200) + 100; // 100-299
            case LYCEUM:
                return rand.nextInt(100) + 50; // 50-149
            default:
                return 0;
        }
    }

    @Override
    public void setFieldsFromString(String data) throws InvalidHouseDataException {
        String[] tokens = data.split(";");
        try {
            if (tokens.length != 2) {
                throw new InvalidHouseDataException("School data must have 2 fields: address;accreditationLevel");
            }
            setAddress(tokens[0]);
            setAccreditationLevel(AccreditationLevel.valueOf(tokens[1].trim().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new InvalidHouseDataException("Invalid accreditation level.", e);
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("School at " + address + " with accreditation level " + accreditationLevel +
                " and " + numberOfStudents + " students.");
    }
}
