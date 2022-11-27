package ex;


import containers.CountedString;

import java.util.HashMap;
import java.util.Map;

class CountedString3 extends CountedString {

    public CountedString3(String s) {
        super(s);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode(); //s对象的内存地址
        return result;
    }
}

public class Ex27 {

    public static void main(String[] args) {
        Map<CountedString,Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i],i);  //Autobox int -> Integer
        }
        System.out.println(map);
        for (CountedString cstring : cs) {
            System.out.println("Looking up " + cstring);
            System.out.println(map.get(cstring));
            System.out.println("key equals " + cstring.equals(cs[0]));
        }
    }
}
