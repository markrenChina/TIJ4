package generics;

class Dog{}

class PerformingDog extends Dog implements Performs {
    @Override
    public void speak() {
        System.out.println("Woof");
    }

    @Override
    public void sit() {
        System.out.println("Sitting");
    }
}

class Robot implements Performs {
    @Override
    public void speak() {
        System.out.println("Click");
    }

    @Override
    public void sit() {
        System.out.println("Clank");
    }
}

class Communicate {
    public static <T extends Performs> void perform(T anything){
        anything.speak();
        anything.sit();
    }
}

public class DogsAndRobots {

    public static void main(String[] args) {
        PerformingDog d = new PerformingDog();
        Robot r = new Robot();
        Communicate.perform(d);
        Communicate.perform(r);
    }
}
