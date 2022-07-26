package ex21;

import java.util.HashMap;
import java.util.Map;

class Building {}
class House extends Building {}

public class ClassTypeCapture {
    Map<String,Class<?>> map = new HashMap<>();

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ClassTypeCapture ctt1 = new ClassTypeCapture();
        ctt1.addType("Building",Building.class);
        ctt1.addType("House",House.class);
        System.out.println(ctt1.createNew("House").getClass());
    }

    public void addType(String typename,Class<?> kind){
        map.put(typename,kind);
    }

    public Object createNew(String typename) throws InstantiationException, IllegalAccessException {
        return map.get(typename).newInstance();
    }
}
