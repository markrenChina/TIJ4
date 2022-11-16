package ex;

import net.mindview.util.CountingMapData;
import net.mindview.util.Print;

import java.util.Map;
import java.util.Properties;

public class Ex14 {

    public static void printKeys(Map<Object,Object> map){
        Print.printnb("Size = " + map.size() + ", ");
        Print.printnb("Keys: ");
        System.out.println(map.keySet()); //Produce a Set of the keys
    }

    public static void test(Map<Object,Object> map) {
        System.out.println(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        //Map has 'Set' behavior for keys
        map.putAll(new CountingMapData(25));
        printKeys(map);
        //Producing a Collection of the values
        Print.printnb("Values: ");
        System.out.println(map.values());
        System.out.println(map);
        System.out.println("map.containsKey(11): " + map.containsKey(11));
        System.out.println("map.get(11): " + map.get(11));
        System.out.println("map.containsValues(\"F0\"): " + map.containsValue("F0"));
        Object key = map.keySet().iterator().next();
        System.out.println("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        System.out.println("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));

        //Operations on the Set change the Map
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty(): " + map.isEmpty());
        System.out.println("================================");
    }

    public static void main(String[] args) {
        test(new Properties());
    }
}
