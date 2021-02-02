import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 参数的匿名内部类
 */
public class DirList3 {
    public static void main(final String[] args) {
        File path = new File(".");
        String[] list;
        //args = new String[1];
        //args[0] = "";
        if (args.length == 0){
            System.out.println("is 0");
            list = path.list();
        }else {
            System.out.println("isFilter");
            list = path.list(new FilenameFilter() {
                //因为匿名内部类使用了args[0]那么main方法的参数必须为final
                private Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list){
            System.out.println(dirItem);
        }
    }
}
