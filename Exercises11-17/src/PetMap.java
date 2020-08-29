import pets.Cat;
import pets.Dog;
import pets.Hamster;
import pets.Pet;

import java.util.HashMap;
import java.util.Map;

public class PetMap {
    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<String,Pet>();
        petMap.put("My Cat",new Cat("Molly"));
        petMap.put("My Dog",new Dog("Ginger"));
        petMap.put("My Hamster",new Hamster("Bosco"));
        System.out.println(petMap);
        //dog 获取的是petMap中My Dog KEY对应的new Dog("Ginger")对象
        Pet dog = petMap.get("My Dog");
        System.out.println(dog);
        System.out.println(petMap.containsKey("My Dog"));
        System.out.println(petMap.containsValue(dog));
    }
}
