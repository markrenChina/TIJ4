package ex17;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ex17 {
    public static void main(String[] args) {
        Map<String,Gerbil> m = new HashMap<>();
        m.put("Fuzzy",new Gerbil(4));
        m.put("Spot",new Gerbil(5));

        System.out.println(m.keySet());
        Iterator<String> it = m.keySet().iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.println("Gerbil: "+ s);
            m.get(s).hop();
        }
    }
}
