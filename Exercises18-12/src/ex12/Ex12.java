package ex12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Ex12 {
    static String file = "/Users/workspace/IdeaProjects/TIJ4/Exercises18-1/out/production/Exercises18-12/ex12/Ex12.out";

    public static List<String> read(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String value;
        LinkedList<String> list = new LinkedList<>();
        while ((value = reader.readLine()) != null) {
            list.add(value);
        }
        reader.close();
        return list;
    }

    public static void main(String[] args) throws IOException {
        //File file = new File(".");
        //System.out.println(Arrays.toString(file.list()));
        //idea设置了out目录，18-1/out


        List<String> list = read("/Users/workspace/IdeaProjects/TIJ4/Exercises18-1/out/production/Exercises18-7/ex07/test.txt");

        PrintWriter out = new PrintWriter(file);
        Stream.iterate(list.size() - 1, n -> n - 1)
                .limit(list.size()).map(e -> (list.size() - e)+"; " + list.get(e))
                .forEach(out::println);
        out.close();
    }
}
