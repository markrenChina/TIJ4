package ex;

import net.mindview.util.TextFile;

import java.util.HashMap;

public class Ex13 {

    public static void main(String[] args) {
        TextFile textFile = new TextFile("./Replacements.txt");
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        textFile.forEach(s ->{
            for (String word : s.split("\\s|\\.")) {
                Integer count = hashMap.get(word.hashCode());
                hashMap.put(
                        word.hashCode(),
                        (count == null) ? 1 : ++count
                );
            }
            }


        );
        hashMap.forEach((integer, integer2) -> {
            System.out.println(integer +": " + integer2);
        });
    }
}
