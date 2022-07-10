package typeinfo;

import net.mindview.util.MapData;
import typeinfo.pets.LiteralPetCreator;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class PetCount3 {
    public static void main(String[] args) {
        PetCounter petCount = new PetCounter();
        Arrays.stream(Pets.createArray(20)).forEach(pet -> {
            System.out.print(pet.getClass().getSimpleName() + " ");
            petCount.count(pet);
        });
        System.out.println();
        System.out.println(petCount);
    }

    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        public PetCounter() {
            super(MapData.map(LiteralPetCreator.allTypes, 0));
        }

        public void count(Pet pet) {
            //Class.isInstance() eliminates instanceofs
            for (Map.Entry<Class<? extends Pet>, Integer> pair :
                    entrySet()) {
                if (pair.getKey().isInstance(pet)) {
                    put(pair.getKey(), pair.getValue() + 1);
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("{");
            forEach((key, value) -> {
                result.append(key.getSimpleName());
                result.append("=");
                result.append(value);
                result.append(". ");
            });
            result.delete(result.length() - 2, result.length());
            result.append("}");
            return result.toString();
        }
    }
}
