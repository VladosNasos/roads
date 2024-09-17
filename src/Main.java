public class Main {
    public static void main(String[] args) throws InvalidHouseDataException {
        Street street = TestFactory.createTestStreet();
        Menu menu = new Menu(street);
        menu.displayMenu();
    }
}
