package ex;

import containers.Countries;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Ex2 {

    public static void main(String[] args) {
        Map<String,String> map = new TreeMap<>(Countries.capitals());
        System.out.println(map);
        Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
        while (it.hasNext()){
            if (!it.next().getKey().startsWith("A")){
                it.remove();
            }
        }
        System.out.println(map);
        Set<String> stringSet = map.keySet();
        System.out.println(stringSet);
    }
}
