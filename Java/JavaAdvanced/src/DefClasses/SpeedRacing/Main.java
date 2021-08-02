package DefClasses.SpeedRacing;

import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Car> cars = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split("\\s+");
            Car car = new Car(input[0],
                    Double.parseDouble(input[1]),
                    Double.parseDouble(input[2]));
            cars.add(car);
        }
        String line;
        while (!(line = bf.readLine()).equals("End")) {
            String[] tokens = line.split("\\s+");
            String model = tokens[1];
            int distance = Integer.parseInt(tokens[2]);
            for (Car car : cars) {
                if (car.getModel().equals(model)) {
                    if (car.canMove(distance)) {
                        car.setDistanceTravelled(car.getDistanceTravelled() + distance);
                        double fuelToRemove = car.getFuelCostForKm() * distance;
                        car.setFuelAmount(car.getFuelAmount() - fuelToRemove);
                    } else {
                        System.out.println("Insufficient fuel for the drive");
                    }
                }
            }
        }
        cars.stream().forEach(car -> {
            System.out.printf("%s %.2f %d%n",
                    car.getModel(), car.getFuelAmount(),
                    car.getDistanceTravelled());
        });
    }
}
