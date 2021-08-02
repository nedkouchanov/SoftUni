package DefClasses.ExCompanyRoaster;


import DefClasses.OpinionPoll.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String departmentName = input[3];
            Department department;
            if (departments.size() == 0) {
                departments.add(new Department((departmentName)));
            } else {
                for (Department currentDepartment : departments) {
                    if (!currentDepartment.getName().equals(departmentName)) {
                        departments.add(new Department((departmentName)));
                        break;
                    } else {
                        department = currentDepartment;
                    }
                    Employee employee;
                    switch (input.length) {
                        case 4:
                            employee = new Employee(name, salary, position, department);
                            break;
                        case 5:
                            try {
                                int age = Integer.parseInt(input[4]);
                                employee = new Employee(name, salary, position, department, age);
                            } catch (NumberFormatException e) {
                                employee = new Employee(name, salary, position, department, input[4]);//email e input[4]
                            }
                            break;
                        default:
                            employee = new Employee(name, salary, position,
                                    department, input[4], Integer.parseInt(input[5]));
                            break;
                    }
                    for (int j = 0; j < departments.size(); j++) {
                        if (employee.getDepartment().getName().equals(departments.get(j).getName())) {
                            List<Employee> employees = departments.get(j).getEmployees();
                            employees.add(employee);
                            departments.get(j).setEmployees(employees);
                        }
                    }

                }
            }
        }

    }
}



