package ex14;

import exceptions.OnOffException1;
import exceptions.OnOffException2;
import exceptions.Switch;

//确保程序结束的时候开关是关闭的
public class OnOffSwitch {
    private static Switch sw = new Switch();
    public static void f() throws OnOffException1, OnOffException2 ,RuntimeException{
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            sw.on();
            //Code that can throw exceptions...
            f();

            sw.off(); //有了finally多余
        }catch (OnOffException2 | OnOffException1  e){
            System.out.println(e.getClass().getSimpleName());
            sw.off();//有了finally多余
        }
        assert !sw.read();
    }
}
