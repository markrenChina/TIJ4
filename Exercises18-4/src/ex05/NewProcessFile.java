package ex05;

import net.mindview.util.Directory;
import net.mindview.util.ProcessFiles;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class NewProcessFile {

    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String regex;

    public NewProcessFile(Strategy strategy, String regex) {
        this.strategy = strategy;
        this.regex = regex;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            }else {
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()){
                        processDirectoryTree(fileArg);
                    }else {
                        //Allow user to leave off extension
                        if (!Pattern.compile(regex).matcher(fileArg.getName()).matches()) {
                            //arg += "." + ext;
                            strategy.process(new File(arg).getCanonicalFile());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File file: Directory.walk(
                root.getAbsolutePath(),regex
        )) {
            strategy.process(file.getCanonicalFile());
        }
    }

    public static void main(String[] args) {
        new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, "*.java").start(args);
    }
}
