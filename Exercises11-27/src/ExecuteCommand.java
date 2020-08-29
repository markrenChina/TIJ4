import java.util.Queue;

public class ExecuteCommand {
    public static void execute(Queue<Command> queue){
        while (queue.peek() != null) {
            queue.remove().operation();
        }
    }
}
