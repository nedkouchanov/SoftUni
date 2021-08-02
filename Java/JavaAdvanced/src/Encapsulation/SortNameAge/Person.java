package Encapsulation.SortNameAge;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age) {
        this(firstName, lastName, age, 0);
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.initialSalary(salary);
    }

    public void initialSalary(double salary) {
        if (salary < 460) {
            throw new IllegalStateException
                    ("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalStateException
                    ("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalStateException
                    ("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalStateException
                    ("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double increase) {
        if (this.getAge() < 30) {
            increase /= 2;

        }
        this.salary += salary * increase / 100;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva",
                this.getFirstName(), this.getLastName(), this.getSalary());
    }
}
