import java.io.*;

public class Ex21 {

    public static void main(String[] args) throws IOException {
        File file = new File("TextFile.java");
        BufferedInputStream inFile =
                new BufferedInputStream(new
                        FileInputStream(file));
        //重定向
        System.setIn(inFile);
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        while((s = stdin.readLine()) != null)
            System.out.println(s.toUpperCase());
    }

}
