package WorkingWithAbstraction.TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TrafficLights[] lights = Arrays
                .stream(scan.nextLine()
                        .split(" "))
                .map(TrafficLights::valueOf)
                .toArray(TrafficLights[]::new);
        int n = Integer.parseInt(scan.nextLine());
        TrafficLights[] trafficLights = TrafficLights.values();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < lights.length; j++) {
                TrafficLights light = lights[j];
                int nextIndex = light.ordinal() + 1;
                if (nextIndex >= 3) {
                    nextIndex = 0;
                }
                TrafficLights value = trafficLights[nextIndex];
                lights[j] = value;
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
