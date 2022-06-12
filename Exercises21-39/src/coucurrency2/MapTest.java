package coucurrency2;

import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

abstract class MapTest extends Tester<Map<Integer,Integer>>{
    MapTest(String testId, int nReaders, int nWriters) {
        super(testId, nReaders, nWriters);
    }

    @Override
    void startReadersAndWriters() {
        IntStream.range(0,nReaders).forEach(i->
                exec.execute(new Reader()));
        IntStream.range(0,nWriters).forEach(i->
                exec.execute(new Writer()));
    }

    class Reader extends TestTask {
        long result = 0;
        @Override
        void test() {
            LongStream.range(0,testCycles).forEach(l ->
                    IntStream.range(0,containerSize).forEach(i->
                            result+=testContainer.get(i)
                    )
            );
        }

        @Override
        void putResults() {
            readResult += result;
            readTime += duration;
        }
    }

    class Writer extends TestTask {

        @Override
        void test() {
            LongStream.range(0,testCycles).forEach(l ->
                    IntStream.range(0,containerSize).forEach(i->
                            testContainer.put(i,writeData[i])
                    )
            );
        }

        @Override
        void putResults() {
            writeTime += duration;
        }
    }
}
