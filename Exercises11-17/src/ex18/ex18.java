package ex18;

import ex17.Gerbil;

import java.util.*;

public class ex18 {
    public static void main(String[] args){
        Map<String, Gerbil> gerbils = new HashMap<String, Gerbil>();
        gerbils.put("Fuzzy", new Gerbil(0));
        gerbils.put("Spot", new Gerbil(1));
        gerbils.put("Speedy", new Gerbil(2));
        gerbils.put("Dopey", new Gerbil(3));
        gerbils.put("Sleepy", new Gerbil(4));
        gerbils.put("Happy", new Gerbil(5));
        gerbils.put("Funny", new Gerbil(6));
        gerbils.put("Silly", new Gerbil(7));
        gerbils.put("Goofy", new Gerbil(8));
        gerbils.put("Wowee", new Gerbil(9));
        System.out.println(gerbils);

        Set<String> hSet = new HashSet<>(gerbils.keySet());
        System.out.println(hSet);

        Set<String> tSet = new TreeSet<>(gerbils.keySet());
        System.out.println(tSet);

        LinkedHashMap<String,Gerbil> lHashMap = new LinkedHashMap<>();
        for (String s : tSet){
            lHashMap.put(s,gerbils.get(s));
        }
        System.out.println(lHashMap);

        //TreeMap的效果等同于 先TreeSet 再加入LinkedHashMap
        Map<String,Gerbil> gerbils2 = new TreeMap<>(gerbils);
        System.out.println(gerbils2);
    }
}
