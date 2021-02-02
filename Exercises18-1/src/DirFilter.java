import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * FilenameFilter 过滤文件名
 */
public class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name){
        return pattern.matcher(name).matches();
    }
}
