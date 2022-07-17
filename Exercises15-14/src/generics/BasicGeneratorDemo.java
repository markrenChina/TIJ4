package generics;

import net.mindview.util.Generator;
import util.BasicGenerator;

public class BasicGeneratorDemo {

    public static void main(String[] args) {
        //create方法利用类型推断创建了一个构造器
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
    }
}
