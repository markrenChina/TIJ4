package ex01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class ex03 {
    public static void main(final String[] args) {
        File path = new File(".");
        File[] list;
        //args = new String[1];
        //args[0] = "";
        if (args.length == 0){
            System.out.println("is 0");
            list = path.listFiles();
        }else {
            System.out.println("isFilter");
            list = path.listFiles(new FilenameFilter() {
                //因为匿名内部类使用了args[0]那么main方法的参数必须为final
                private Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        Arrays.sort(list);
        Long sum = 0L;
        for(File dirItem : list){
            System.out.println(dirItem.getName());
            sum += dirItem.length();
        }
        System.out.println(sum);
    }
}
