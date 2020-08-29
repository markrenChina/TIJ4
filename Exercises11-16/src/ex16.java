import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class ex16 {
    public static void main(String[] args) {
        Set<Character> set = new TreeSet<>();
        Collections.addAll(set, 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        Set<String> words = new TreeSet<String>(
                new TextFile("UniqueWords.java", "\\W+"));
        System.out.println(words);
        //元音总数
        int totalCount = 0;
        for (String s : words) {
            //单个单词元音计数
            int count = 0;
            for (Character c : s.toCharArray()) {
                if (set.contains(c)) {
                    count ++;
                    totalCount ++;
                }
            }
            System.out.print(s +"has "+count +"个元音"+",");
        }
        System.out.println();
        System.out.println("一个有"+totalCount+"个元音");
    }
}
