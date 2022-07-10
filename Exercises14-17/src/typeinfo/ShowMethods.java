package typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

//Using reflection to show all the methods of a class
//even if the methods are defined in the base class
//{Args: typeinfo.ShowMethods}
public class ShowMethods {
    private static String usage =
            "usage:\n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        AtomicInteger liens = new AtomicInteger();
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if (args.length == 1) {
                Arrays.stream(methods).forEach(method -> System.out.println(
                        p.matcher(method.toString()).replaceAll("")
                ));
                Arrays.stream(ctors).forEach(constructor -> System.out.println(
                        p.matcher(constructor.toString()).replaceAll("")
                ));
                liens.set(methods.length + ctors.length);
            } else {
                Arrays.stream(methods)
                        .filter(method -> method.toString().contains(args[1]))
                        .forEach(method -> {
                                    liens.getAndIncrement();
                                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                                }
                        );
                Arrays.stream(ctors)
                        .filter(ctor -> ctor.toString().contains(args[1]))
                        .forEach(constructor ->
                                {
                                    System.out.println(p.matcher(constructor.toString()).replaceAll(""));
                                    liens.getAndIncrement();
                                }
                        );
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
