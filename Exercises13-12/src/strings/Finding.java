package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finding {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\w+")
                .matcher("Evening is full of the linnet's wings");
        while (m.find()){
            //遍历搜索字符串
            System.out.print(m.group() + " ");
        }
        System.out.println();
        int i = 0;
        //i表示字符串中字符的位置，并以其作为搜索的起点。
        while (m.find(i)) {
            //不停地重新定义搜索起点。
            System.out.print(m.group() + " ");
            ++i;
        }
    }
}
