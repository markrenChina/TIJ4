package ex01;

import net.mindview.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 有问题
 */
public class ex01 {
    public static void main(String[] args) {
        File path = new File(".");
        final String filter = "}";
        String[] list = path.list(new FilenameFilter() {
            //Pattern pattern = Pattern.compile(filter);

            @Override
            public boolean accept(File dir, String name) {
                return !(Collections.disjoint(
                        Arrays.asList("ex01"),
                        new TextFile(name, "\\W+")
                )
                );
            }
        });

        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list){
            System.out.println(dirItem);
        }
    }
}
