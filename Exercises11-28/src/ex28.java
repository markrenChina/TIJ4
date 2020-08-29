import java.util.PriorityQueue;
import java.util.Random;

public class ex28 {
    public static void main(String[] args) {
        PriorityQueue<Double> doubles = new PriorityQueue<>();
        Random random = new Random();
        for (int i = 0 ; i < 1000; i ++){
            doubles.offer(random.nextDouble()*i);
        }
        while (doubles.peek() != null){
            System.out.println(doubles.poll());
        }
    }
}
