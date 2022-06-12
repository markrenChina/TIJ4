package coucurrency2;

import net.mindview.util.CountingGenerator;
import net.mindview.util.MapData;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest extends MapTest{
    ConcurrentHashMapTest(int nReaders, int nWriters) {
        super("ConcurrentHashMap", nReaders, nWriters);
    }

    @Override
    Map<Integer, Integer> containerInitializer() {
        return new ConcurrentHashMap<Integer,Integer>(
                MapData.map(
                        new CountingGenerator.Integer(),
                        new CountingGenerator.Integer(),
                        containerSize
                )
        );
    }
}
