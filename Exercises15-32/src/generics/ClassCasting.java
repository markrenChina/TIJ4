package generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

class Widget{}

public class ClassCasting {
    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception{
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(args[0])
        );
        List<Widget> lw = List.class.cast(in.readObject());
        //List<Widget> lw = List<Widget>.class.cast(in.readObject());
        //会有警告
        //List<Widget> lw2 = (List<Widget>) List.class.cast(in.readObject());
    }
}
