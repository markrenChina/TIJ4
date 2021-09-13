import java.io.IOException;
import java.net.ServerSocket;

public class TestServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(7070);
        for (;;){
            server.accept();
        }
    }
}
