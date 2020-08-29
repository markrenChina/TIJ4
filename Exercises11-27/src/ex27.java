import java.util.LinkedList;
import java.util.Queue;

public class ex27 {
    public static void main(String[] args) {
        CmdQueue cmdQueue = new CmdQueue();
        cmdQueue.addCommand("one");
        cmdQueue.addCommand("two");
        cmdQueue.addCommand("three");
        cmdQueue.addCommand("four");
        ExecuteCommand.execute(cmdQueue.addCommand("five"));
    }
}
