import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExercise {
    public static void main(String[] args) {
        Map<String, Car> carMap = new HashMap<>();
        Map<Car, String> ownerMap;

//        carMap.put("Anton", new Car("BMW", 2020, "black"));
//        carMap.put("Boris", new Car("Tesla", 2022, "white"));
//        carMap.put("Yulia", new Car("Fiat", 2020, "red"));
//        carMap.put("Stas", new Car("Lada", 2000, "red"));
//        writeCarMapToFile(carMap, "input.txt");

        ownerMap = readOwnerMapFromFile();

        Scanner userInput = new Scanner(System.in);

        String owner = ownerMap.get(new Car(userInput.next(), userInput.nextInt(), userInput.next()));

        if (owner != null)
            System.out.println(owner);
        else System.out.println("Car not found");

//        System.out.println(carMap);
//
//        String x1 = "Boris";
//        Car result1 = carMap.get(x1);
//        System.out.println(result1);
//
//        String x2 = "x";
//        Car result2 = carMap.get(x2);
//        System.out.println(result2);
    }

    private static HashMap<Car, String> readOwnerMapFromFile() {
        HashMap<Car, String> ownerMap = new HashMap<>();
        try (BufferedReader input = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            String[] splitLine;
            while ((line = input.readLine()) != null) {
                splitLine = line.split(";");
                ownerMap.put(new Car(splitLine[1], Integer.parseInt(splitLine[2]), splitLine[3]), splitLine[0]);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ownerMap;
    }

    private static void writeCarMapToFile(Map<String, Car> carMap, String fileName) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(fileName))) {
            carMap.forEach((owner, car) -> {
                try {
                    output.write(owner + ";" + car.model + ";" + car.year + ";" + car.color + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}