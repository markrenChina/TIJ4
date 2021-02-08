import java.io.*;

/**
 * java se 5 辅助构造器，快捷构建
 */
public class FileOutputShortcut {
    static String file = "FileOutputShortcut.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("FileOutputShortcut.java")
                )
        );
        //依然使用缓存
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ";" + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
