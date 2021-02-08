package demo;

import net.mindview.util.Directory;
import net.mindview.util.PPrint;

import java.io.File;

public class DirectoryDemo {

    public static void main(String[] args) {
        //all dir
        //PPrint.pprint(Directory.walk(".").dirs);
        //all file begin with E
        //for (File file : Directory.local(".","E.*")) System.out.println(file);
        System.out.println("-----------------------");
        //all files containing "X" or "x"
        for ( File file : Directory.walk(".",".*[Xx].*\\.class")) System.out.println(file);
    }
}
