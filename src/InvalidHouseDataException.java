public class InvalidHouseDataException extends Exception {
    public InvalidHouseDataException(String message) {
        super(message);
    }

    public InvalidHouseDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
