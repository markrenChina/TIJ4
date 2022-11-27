package ex;

import containers.Test;
import containers.TestParam;
import containers.Tester;
import net.mindview.util.CountingGenerator;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Ex34 {
    static List<Test<Set<String>>> tests = new ArrayList<>();
    
    static List<String> staticStringList = new ArrayList<>(10000 *2);

    static {
        for (int i = 0; i < 10000 * 2; i++) {
            staticStringList.add(new CountingGenerator.String( ThreadLocalRandom.current().nextInt(100)).next());
        }
        
        tests.add(new Test<Set<String>>("add") {
            @Override
            public int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    set.clear();
                    for (int j = 0; j < size; j++) {
                        set.add(staticStringList.get(j));
                    }
                }
                return loops * size;
            }
        });

        tests.add(new Test<Set<String>>("contains") {
            @Override
            public int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < span; j++) {
                        set.contains(staticStringList.get(j));
                    }
                }
                return loops * span;
            }
        });

        tests.add(new Test<Set<String>>("iterate") {
            @Override
            public int test(Set<String> set, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()){
                        it.next();
                    }
                }
                return loops *set.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0){
            Tester.defaultParams = TestParam.array(args);
        }
        Tester.fieldWidth = 10;
        SetStringTester.run(new TreeSet<String>(),tests);
        SetStringTester.run(new HashSet<>(),tests);
        SetStringTester.run(new LinkedHashSet<>(),tests);
    }

    static class SetStringTester extends Tester<Set<String>>{
        public SetStringTester(Set<String> container, List<Test<Set<String>>> tests) {
            super(container, tests);
        }

        public static void run(Set<String> list,List<Test<Set<String>>> tests) {
            new SetStringTester(list,tests).timedTest();
        }

        @Override
        protected Set<String> initialize(int size) {
            container.addAll(staticStringList.subList(0,size));
            return container;
        }
    }
}
