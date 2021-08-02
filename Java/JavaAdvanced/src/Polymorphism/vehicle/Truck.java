package Polymorphism.vehicle;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        double fuelCost = (super.getFuelConsumption() + 1.6) * distance;
        if (fuelCost <= super.getFuelQuantity()) {
            super.setFuelQuantity(super.getFuelQuantity() - fuelCost);
            DecimalFormat decimalFormat = new DecimalFormat("###.##");
            System.out.printf("Polymorphism.vehicle.Truck travelled %s km%n", decimalFormat.format(distance));
        } else {
            System.out.println("Polymorphism.vehicle.Truck needs refueling");
        }
    }

    @Override
    public void refuel(double quantity) {
        if (quantity > 0) {
            if (quantity + super.getFuelQuantity() <= super.getTankCapacity()) {
                super.setFuelQuantity(super.getFuelQuantity() + quantity * 0.95);
            } else {
                System.out.println("Cannot fit fuel in tank");
            }
        } else {
            System.out.println("Fuel must be a positive number");
        }
    }

    @Override
    public String toString() {
        return String.format("Polymorphism.vehicle.Truck: %.2f", super.getFuelQuantity());
    }
}
