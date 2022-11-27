package ex;

import containers.SimpleHashMap;
import net.mindview.util.TextFile;

public class Ex19 {

    public static void main(String[] args) {
        TextFile textFile = new TextFile("./Replacements.txt");
        SimpleHashMap<Integer,Integer> hashMap = new SimpleHashMap<>();
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
