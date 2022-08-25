package ex35;

import coffee.Coffee;
import coffee.Latte;
import coffee.Mocha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex35 {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs){
        probablyDogs.add(new Mocha());
    }

    public static void main(String[] args) {
        List<Mocha> mocha1 = new ArrayList<>();
        oldStyleMethod(mocha1); //Quietly accepts a Cat
        List<Latte> mocha2 = Collections.checkedList(
                new ArrayList<>(), Latte.class
        );
        try {
            oldStyleMethod(mocha2); //Throws an exception
        } catch (Exception e){
            System.out.println(e);
        }

        //Derived types work fine
        List<Coffee> pets = Collections.checkedList(
                new ArrayList<>(),Coffee.class
        );
        pets.add(new Mocha());
        pets.add(new Latte());
    }
}
