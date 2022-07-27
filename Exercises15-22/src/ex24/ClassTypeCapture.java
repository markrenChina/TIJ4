package ex24;

import java.util.HashMap;
import java.util.Map;


interface FactoryI<T> {
    T create();
}

class Foo2<T>{
    private T x;
    public <F extends FactoryI<T>> Foo2(F factory){
        x = factory.create();
    }
}
class Building {
    public static class Factory implements FactoryI<Building> {
        @Override
        public Building create() {
            return new Building();
        }
    }
}
class House extends Building {
    public static class Factory implements FactoryI<House> {
        @Override
        public House create() {
            return new House();
        }
    }
}

public class ClassTypeCapture {
    Map<String,FactoryI> map = new HashMap<>();

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ClassTypeCapture ctt1 = new ClassTypeCapture();
        ctt1.addType("Building",new Building.Factory());
        ctt1.addType("House",new Building.Factory());
        System.out.println(ctt1.createNew("House").getClass());
    }

    public <T,F extends FactoryI<T>> void addType(String typename,F kind){
        map.put(typename,kind);
    }

    public Object createNew(String typename) {
        return map.get(typename).create();
    }
}
