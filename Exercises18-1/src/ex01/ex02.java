package ex01;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class ex02 {
    static class SortedDirList2 {
        private String[] dirList;
        public SortedDirList2(File dir) {
            dirList = dir.list();
            Arrays.sort(dirList, String.CASE_INSENSITIVE_ORDER);
        }
        public String[] list() { return dirList; }

        /**
         * File list(FilenameFilter) 源码实现
         */
        public String[] list(String regex) {
            Pattern pattern = Pattern.compile(regex);
            ArrayList<String> slist = new ArrayList<String>();
            int count = 0;
            for(String s : dirList) {
                if(pattern.matcher(s).matches()) {
                    count++;
                    slist.add(s);
                }
            }
            return slist.toArray(new String[count]);
        }
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(String s : dirList) sb.append(s + '\n');
            return sb.toString();
        }
        public static void main(String[] args) {
            SortedDirList2 dirList = new SortedDirList2(new File("."));
            System.out.println(dirList);
            for(String s : dirList.list())
                System.out.println(s);
            System.out.println();
            for(String s : dirList.list(".+\\.java"))
                System.out.println(s);
        }
    }
}
