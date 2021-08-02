package Polymorphism.vehicle;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
    }

    @Override
    public void drive(double distance) {
        double fuelCost = (super.getFuelConsumption() + 0.9) * distance;
        if (fuelCost <= super.getFuelQuantity()) {
            super.setFuelQuantity(super.getFuelQuantity() - fuelCost);
            DecimalFormat decimalFormat = new DecimalFormat("###.##");
            System.out.printf("Polymorphism.vehicle.Car travelled %s km%n", decimalFormat.format(distance));
        } else {
            System.out.println("Polymorphism.vehicle.Car needs refueling");
        }
    }

    @Override
    public void refuel(double quantity) {
        if (quantity > 0) {
            if(quantity+super.getFuelQuantity()<=super.getTankCapacity()){
            super.setFuelQuantity(super.getFuelQuantity() + quantity);
        } else {
                System.out.println("Cannot fit fuel in tank");
            }
        } else {
            System.out.println("Fuel must be a positive number");
        }
    }

    @Override
    public String toString() {
        return String.format("Polymorphism.vehicle.Car: %.2f", super.getFuelQuantity());
    }
}