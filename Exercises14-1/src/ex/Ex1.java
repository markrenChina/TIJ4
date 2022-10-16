package ex;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy{
    //Comment out the following default constructor
    //to see NoSuchMethodError from(*1*)

    //public Toy() {}
    public Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
    FancyToy(){super(1);}
}

public class Ex1 {
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
            c = Class.forName("ex.FancyToy");
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
            //Constructor constructor = up.getDeclaredConstructor();
            obj = up.newInstance();
        } catch ( InstantiationException | IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
            throw new RuntimeException(e);
        }
        printInfo(obj.getClass());
    }
}
