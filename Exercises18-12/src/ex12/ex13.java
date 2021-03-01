package ex12;

import java.io.*;

//writer
public class ex13 {
    static String file = "/Users/workspace/IdeaProjects/TIJ4/Exercises18-12/src/ex12/BufferedInputFile.java";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read(file)
                )
        );
        /*PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(file)));*/
        LineNumberReader lineNumberReader = new LineNumberReader(in);
        int lineCount = 1;
        String s;
        while ((s = lineNumberReader.readLine()) != null) {
            System.out.println(lineNumberReader.getLineNumber() + ":" + s);
        }
        lineNumberReader.close();
        //System.out.println(BufferedInputFile.read("/Users/workspace/IdeaProjects/TIJ4/Exercises18-1/out/production/Exercises18-12/ex12/" + file));
    }
}
