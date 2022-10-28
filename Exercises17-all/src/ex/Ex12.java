package ex;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Ex12 {

    public static void test(Map<String,String> map){
        map.put("sky","blue");
        map.put("grass","green");
        map.put("ocean","dancing");
        map.put("tree","tall");
        map.put("earth","brown");
        map.put("sun","warm");
        System.out.println(map);
        System.out.println(map.get("ocean"));
        System.out.println(map.get("abc"));
        System.out.println("=======================");
    }

    public static void main(String[] args) {
        test(new HashMap<>());
        test(new TreeMap<>());
        test(new LinkedHashMap<>());
    }
}
