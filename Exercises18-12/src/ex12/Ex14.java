package ex12;

import java.io.*;

//writer
public class Ex14 {
    static String file = "/Users/workspace/IdeaProjects/TIJ4/Exercises18-12/src/ex12/BufferedInputFile.java";
    static String outFile1 = "/Users/workspace/IdeaProjects/TIJ4/Exercises18-12/src/ex12/BufferedInputFileBuffed.out";
    static String outFile2 = "/Users/workspace/IdeaProjects/TIJ4/Exercises18-12/src/ex12/BufferedInputFileNoBuffed.out";

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader( new StringReader(
                BufferedInputFile.read(file)
        ));
        ;

        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read(file)));
        // Buffered writer:
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(outFile1)));
        int lineCount = 1;
        String s;
        long start = System.nanoTime();
        while((s = in.readLine()) != null )
            out.println(lineCount++ + ": " + s);
        long duration = System.nanoTime() - start;
        out.close();
        System.out.println("Buffered write:   " + duration + " nanoseconds");
        BufferedReader in2 = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read(file)));
        // Unbuffered writer:
        PrintWriter out2 = new PrintWriter(new FileWriter(outFile2));
        int lineCount2 = 1;
        String s2;
        long start2 = System.nanoTime();
        while((s2 = in2.readLine()) != null )
            out2.println(lineCount2++ + ": " + s2);
        long duration2 = System.nanoTime() - start2;
        out2.close();
        System.out.println("Unbuffered write: " + duration2 + " nanoseconds");
        // Show the stored files:
        System.out.println("file: " + BufferedInputFile.read(outFile1));
        System.out.println("file2: " + BufferedInputFile.read(outFile2));
    }
}
