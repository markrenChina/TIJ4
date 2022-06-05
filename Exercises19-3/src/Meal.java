import java.util.stream.IntStream;

public class Meal {
    public static void main(String[] args) {
        IntStream.range(0, 5).forEach(i -> {
            for (Course c : Course.values()) {
                Food food = c.randomSelection();
                System.out.println(food);
            }
            System.out.println("------------");
        });
    }
}
