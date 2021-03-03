import java.util.HashMap;
import java.util.Map;

public class Ex17 {

    public static void main(String[] args) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        TextFile.read("TextFile.java")
                .chars()
                .mapToObj(i->(char)i)
                .forEach(word -> {
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    }else {
                        map.put(word,1);
                    }
                });
        System.out.println(map);
    }
}
