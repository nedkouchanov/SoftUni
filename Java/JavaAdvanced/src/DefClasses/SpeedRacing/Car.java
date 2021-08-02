package DefClasses.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostForKm;
    private int distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCostForKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.distanceTravelled = 0;
        this.fuelCostForKm = fuelCostForKm;
    }

    public double getFuelCostForKm() {
        return fuelCostForKm;
    }

    public void setFuelCostForKm(double fuelCostForKm) {
        this.fuelCostForKm = fuelCostForKm;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public boolean canMove(int distance) {
        return this.fuelAmount >= this.fuelCostForKm*distance;


    }

}
