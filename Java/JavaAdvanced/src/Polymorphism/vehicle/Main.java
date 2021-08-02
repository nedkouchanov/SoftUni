package Polymorphism.vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] carInfo = scan.nextLine().split(" ");
        Car car = new Car(Double.parseDouble(carInfo[1]),
                Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));
        String[] truckInfo = scan.nextLine().split(" ");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]),
                Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));
        String[] busInfo = scan.nextLine().split(" ");
        Bus bus = new Bus(Double.parseDouble(busInfo[1]),
                Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
                case "Drive":
                    if (tokens[1].equals("Polymorphism.vehicle.Car")) {
                        car.drive(Double.parseDouble(tokens[2]));
                    } else if (tokens[1].equals("Polymorphism.vehicle.Truck")) {
                        truck.drive(Double.parseDouble(tokens[2]));
                    } else {
                        bus.setEmpty(false);
                        bus.drive(Double.parseDouble(tokens[2]));
                    }
                    break;
                case "Refuel":
                    if (tokens[1].equals("Polymorphism.vehicle.Car")) {
                        car.refuel(Double.parseDouble(tokens[2]));
                    } else if (tokens[1].equals("Polymorphism.vehicle.Truck")) {
                        truck.refuel(Double.parseDouble(tokens[2]));
                    } else {
                        bus.refuel(Double.parseDouble(tokens[2]));
                    }
                    break;
                case "DriveEmpty":
                    bus.setEmpty(true);
                    bus.drive(Double.parseDouble(tokens[2]));
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
