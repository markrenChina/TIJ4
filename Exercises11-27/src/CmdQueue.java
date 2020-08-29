import java.util.LinkedList;
import java.util.Queue;

public class CmdQueue {
    Queue<Command> queue = new LinkedList<>();

    public  Queue<Command> addCommand(String cmd){
        queue.offer(new Command(cmd));
        return queue;
    }
}
