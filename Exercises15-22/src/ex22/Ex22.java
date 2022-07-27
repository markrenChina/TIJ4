package ex22;

import java.util.Arrays;

class ClassAsFactory<T>  {
    T x;

    public ClassAsFactory(Class<T> kind,Object... args) {
        if (args.length == 0){
            try {
                x = kind.newInstance();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }else {
            try {
                Class<?>[] classes = new Class[args.length];
                for (int i = 0; i < args.length;++i) {
                    classes[i] = args[i].getClass();
                }
                Arrays.stream(kind.getConstructors()).forEach(
                        System.out::println
                );
                x = kind.getConstructor(classes).newInstance(args);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }
}

class Employee {

    public Employee(int any) {
        //TODO int error .int's Class = Integer.TYPE
    }
}


public class Ex22 {

    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class,1);
        System.out.println("ClassAsFactory<Employee> success");
    }
}
