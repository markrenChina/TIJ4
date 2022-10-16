package ex;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex10 {
    //@SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<List<String>> ls = new ArrayList<>();
        List[] la = new List[10];
        ls = Arrays.asList(la);  //"Uncheck" warning
        //ls.add(new ArrayList<>());
        //Compile-time checking produces an error
        //ls[1] = new ArrayList<Integer>();

        //The problem: List<String> is a subtype of Object
        //Object[] objects = ls;  //So assignment is OK
        //Compiles and runs without complaint;
        //objects[1] = new ArrayList<Integer>();

        //However. if your needs are straightforward it is
        //possible to create an array of generics ,albeit
        //with an "unchecked" warning;
        List<List<BerylliumSphere>> spheres = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            spheres.add(new ArrayList<>()) ;
        }
    }
}
