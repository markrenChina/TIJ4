import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
    //Read a file as a single string
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            try (BufferedReader in = new BufferedReader(new FileReader(
                    new File(fileName).getAbsoluteFile()
            ))) {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    //write a single file in one method call:
    public static void write(String fileName, String text) {
        try (PrintWriter out = new PrintWriter(
                new File(fileName).getAbsoluteFile()
        )) {
            out.print(text);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //Read a file,split by any regular expression
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        //Regular expression split() often leaves an empty
        //String at the first position
        if (get(0).equals("")) remove(0);
    }

    // Normally read by lines
    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void writes(String fileName) {
        try (PrintWriter out = new PrintWriter(
                new File(fileName).getAbsoluteFile()
        )) {
            for (String item : this) {
                out.println(item);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file = read("TextFile.txt");
        write("test.txt",file);
        TextFile text = new TextFile("test.txt");
        text.writes("test2.txt");
        //break into unique sorted list of words
        TreeSet<String> words = new TreeSet<String> (
                new TextFile("TextFile.java","\\W+")
        );
        //Display the capitalized words:
        System.out.println(words.headSet("a"));
    }
}
