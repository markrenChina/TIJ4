import java.io.IOException;
import java.io.PipedReader;

public class Receiver implements Runnable{

    private PipedReader in;

    public Receiver(Sender sender) throws IOException {
        this.in = new PipedReader(sender.getPipedWriter());
    }

    @Override
    public void run() {
        try {
            while (true){
                //Blocks until characters are there
                System.out.println("Read: " + (char)in.read()+ ", ");
            }
        }catch (IOException e){
            System.out.println(e + " Receiver read exception");
        }
    }
}
