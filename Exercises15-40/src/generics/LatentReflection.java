package generics;

import java.lang.reflect.Method;

class Mime {
    public void walkAgainstTheWind() {}
    public void sit() {
        System.out.println("Pretending to sit");
    }
}

//Does not implement Performs:
class SmartDog{
    public void speak() {
        System.out.println("Woof!");
    }
    public void sit(){
        System.out.println("Sitting");
    }
}

class CommunicateReflectively {
    public static void perform(Object speaker){
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker +" cannot speak");
            }

            try {
                Method speak = spkr.getMethod("sit");
                speak.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker +" cannot sit");
            }
        }catch (Exception e){
            throw new RuntimeException(speaker.toString(),e);
        }
    }
}

public class LatentReflection {

    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Robot());
        CommunicateReflectively.perform(new Mime());
    }
}
