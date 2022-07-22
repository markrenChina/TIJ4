package generics;

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {

    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<>();
        List<String> stringList = stringMaker.create();
    }

    List<T> create() { return new ArrayList<>(); }
}
