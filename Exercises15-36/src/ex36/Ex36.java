package ex36;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface Processor<T,E extends Exception,E2 extends Exception>{
    void process(List<T> resultCollector) throws E,E2;
}

class ProcessRunner<T,E extends Exception,E2 extends Exception>
        extends ArrayList<Processor<T,E,E2>> {
    List<T> processAll() throws E,E2 {
        List<T> resultCollector = new ArrayList<>();
        for (Processor<T, E,E2> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failure1 extends Exception {}

class Failure2 extends Exception {}
class Processor1 implements Processor<String,Failure1,Failure2> {


    static int count = 3;
    @Override
    public void process(List<String> resultCollector) throws Failure1,Failure2 {
        if (count-- > 1) {
            resultCollector.add("Hep!");
        }else {
            resultCollector.add("Ho!");
        }
        if (count < 0){
            if (new Random().nextBoolean()){
                throw new Failure1();
            }else {
                throw new Failure2();
            }
        }
    }

}

class Processor2 implements Processor<Integer,Failure1,Failure2> {
    static int count = 2;

    @Override
    public void process(List<Integer> resultCollector) throws Failure1,Failure2 {
        if (count-- == 0) {
            resultCollector.add(47);
        }else {
            resultCollector.add(11);
        }
        if (count < 0){
            if (new Random().nextBoolean()){
                throw new Failure1();
            }else {
                throw new Failure2();
            }
        }
    }
}

public class Ex36 {

    public static void main(String[] args) {
        ProcessRunner<String,Failure1,Failure2> runner = new ProcessRunner<>();
        for (int i = 0; i < 10; i++) {
            runner.add(new Processor1());
        }
        try {
            System.out.println(runner.processAll());
        }catch (Failure1 e) {
            System.out.println("runner Failure1");
        }catch (Failure2 e){
            System.out.println("runner Failure2");
        }

        ProcessRunner<Integer,Failure1,Failure2> runner2 = new ProcessRunner<>();
        for (int i = 0; i < 10; i++) {
            runner2.add(new Processor2());
        }
        try {
            System.out.println(runner2.processAll());
        }catch (Failure1 e) {
            System.out.println("runner2 Failure1");
        }catch (Failure2 e){
            System.out.println("runner2 Failure2");
        }
    }
}
