import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 改用匿名内部类
 */
public class DirList2 {
    public static FilenameFilter filter(final String regex){
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        //args = new String[1];
        //args[0] = "";
        if (args.length == 0){
            System.out.println("is 0");
            list = path.list();
        }else {
            System.out.println("isFilter");
            list = path.list(filter(args[0]));
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list){
            System.out.println(dirItem);
        }
    }
}
