import java.util.*;

public class InterfaceVsIterator {
    public static void display(Iterator<Pet> it){
        while(it.hasNext()){
            Pet p = it.next();
            System.out.print(p.id()+";"+p+" ");
        }
        System.out.println();
    }

    public static void display(Collection<Pet> pets){
        for (Pet p : pets ){
            System.out.print(p.id()+";"+p+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> petList = Pets.arrayList(8);
        Set<Pet> petSet = new HashSet<>(petList);
        Map<String,Pet> petMap = new LinkedHashMap<>();
        String[] names = ("Ralph,Eric,Robin,Lacy,Briney,Sam,Spot,Fluffy".split(","));
        for (int i = 0; i< names.length;i++){
            petMap.put(names[i],petList.get(i));
        }
        //void display(Collection<Pet> pets)
        display(petList);
        display(petSet);
        //display(Iterator<Pet> it)
        display(petList.iterator());
        display(petSet.iterator());

        System.out.println(petMap);
        System.out.println(petMap.keySet());

        display(petMap.values());
        display(petMap.values().iterator());
    }
}
