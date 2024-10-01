import java.util.HashMap;
import java.util.Map;

public class MapExercise {
    public static void main(String[] args) {
        Map<String, Car> carMap = new HashMap<>();

        carMap.put("Anton", new Car("BMW", 2020, "black"));
        carMap.put("Boris", new Car("Tesla", 2022, "white"));
        carMap.put("Yulia", new Car("Fiat", 2020, "red"));
        carMap.put("Stas", new Car("Lada", 2000, "red"));

        System.out.println(carMap);

        String x1 = "Boris";
        Car result1 = carMap.get(x1);
        System.out.println(result1);

        String x2 = "x";
        Car result2 = carMap.get(x2);
        System.out.println(result2);
    }
}