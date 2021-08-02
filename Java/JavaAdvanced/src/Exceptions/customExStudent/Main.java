package Exceptions.customExStudent;

public class Main {
    public static void main(String[] args) throws InvalidPersonNameException {
        try {
            new Student("4avdar", "@sda");
        } catch (InvalidPersonNameException ex) {
            ex.printStackTrace();
        }

    }
}
