package ex07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Ex07 {
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
        //list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        //先获得一个倒序的index，然后map产生一个倒序的值
        String query = "B";
        Stream.iterate(list.size() - 1, n -> n - 1).limit(list.size()).map(list::get).forEach(System.out::println);
        //ex08
        Stream.iterate(list.size() - 1, n -> n - 1).limit(list.size()).map(list::get).map(String::toUpperCase)
                .forEach(System.out::println);
        //ex10
        Stream.iterate(list.size() - 1, n -> n - 1)
                .limit(list.size())
                .map(list::get)
                .map(String::toUpperCase)
                .filter(str -> str.contains(query.toUpperCase()))
                .forEach(System.out::println);
    }
}
