import pets.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapOfList {
    public static Map<Person, List<? extends Pet>> petPeople = new HashMap<>();
    static {
        petPeople.put(new Person("Dawn"), Arrays.asList(new Cymric("Molly"),new Mutt("Spot")));
        petPeople.put(new Person("Kate"),Arrays.asList(new Cat("Elsie May"),new Dog("Margrett")));
        petPeople.put(new Person("mark"),Arrays.asList(new Pug("one"),new Cat("two"),new Dog("three")));
    }

    public static void main(String[] args) {
        System.out.println("People: "+petPeople.keySet());
        System.out.println("Pets: "+petPeople.values());
        for (Person person : petPeople.keySet()){
            System.out.println(person + " has:");
            for (Pet pet: petPeople.get(person)) {
                System.out.println("   " + pet);
            }
        }
    }
}
