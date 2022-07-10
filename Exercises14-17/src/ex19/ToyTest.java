package ex19;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy{
    //Comment out the following default constructor
    //to see NoSuchMethodError from(*1*)

    public Toy() {}
    public Toy(int i) {
        System.out.println("use Toy(int i) constructor");
    }
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
    FancyToy(){super(1);}
}

public class ToyTest {
    static void printInfo(Class cc){
        System.out.println("Class name: " + cc.getName() + " is interface?["
                +cc.isInterface()+"]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("ex19.FancyToy");
        }catch (ClassNotFoundException e){
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face: c.getInterfaces()){
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            //Requires default constructor
            Constructor[] ctors = up.getConstructors();
            obj = Arrays.stream(ctors)
                    .filter(constructor -> constructor.getParameterCount() != 0)
                    .findFirst()
                    .get()
                    .newInstance(1);
        }catch (InstantiationException e){
            System.out.println("Cannot instantiate");
            System.exit(1);
        }catch (IllegalAccessException e){
            System.out.println("Cannot access");
            System.exit(1);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        printInfo(obj.getClass());
    }
}
