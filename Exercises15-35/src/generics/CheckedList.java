package generics;

import typeinfo.pets.Cat;
import typeinfo.pets.Dog;
import typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {

    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs){
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1); //Quietly accepts a Cat
        List<Dog> dogs2 = Collections.checkedList(
                new ArrayList<>(), Dog.class
        );
        try {
            oldStyleMethod(dogs2); //Throws an exception
        } catch (Exception e){
            System.out.println(e);
        }

        //Derived types work fine
        List<Pet> pets = Collections.checkedList(
                new ArrayList<>(),Pet.class
        );
        pets.add(new Dog());
        pets.add(new Cat());
    }
}
