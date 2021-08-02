package Exceptions.customExStudent;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) throws InvalidPersonNameException {
        this.setName(name);
        this.email = email;
    }

    private void setName(String name) throws InvalidPersonNameException {
        for(char symbol:name.toCharArray()){
            if(!Character.isAlphabetic(symbol)){
                throw new InvalidPersonNameException("Exceptions.customExStudent.Student name was invalid");
            }
        }
    }

}
