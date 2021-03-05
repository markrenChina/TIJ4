import java.io.*;

/**
 * 重定向
 */
public class Redirecting {

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("Redirecting.java")
        );
        PrintStream out = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream("test.out")
                )
        );
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }
        out.close();
        System.setOut(console);
    }
}
