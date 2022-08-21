package generics;

interface GenericGetter<T extends GenericGetter<T>>{
    T get();
}

interface Getter extends GenericGetter<Getter> {}

//SE5 以上才能通过编译
public class GenericsAndReturnTypes {
    void test(Getter g){
        Getter result = g.get();
        GenericGetter gg = g.get(); //Also the base type
    }
}
