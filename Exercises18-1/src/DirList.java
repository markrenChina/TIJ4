import java.io.File;
import java.util.Arrays;

public class DirList {
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
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list){
            System.out.println(dirItem);
        }

    }
}
