package Inheritance.animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(("Invalid input!"));
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(("Invalid input!"));
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (!gender.equals("Male") && !gender.equals("Female")) {
            throw new IllegalArgumentException(("Invalid input!"));
        }
        this.gender = gender;
    }

    public abstract String produceSound();

    public static Animal createAnimal(String type, String name, int age, String gender) {
        switch (type) {
            case "Frog":
                return new Frog(name, age, gender);
            case "Polymorphism.animals.Dog":
                return new Dog(name, age, gender);
            case "Polymorphism.animals.Polymorphism.animalsExt.Cat":
                return new Cat(name, age, gender);
            case "Tomcat":
                return new Tomcat(name, age);
            case "Kitten":
                return new Kitten(name, age);
            default:
                throw new IllegalArgumentException("Invalid data!");
        }
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s",
                this.getClass().getSimpleName(),
                this.getName(),
                this.getAge(),
                this.getGender(),
                this.produceSound());
    }
}
