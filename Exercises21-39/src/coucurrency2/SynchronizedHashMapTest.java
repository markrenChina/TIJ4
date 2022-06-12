package coucurrency2;

import net.mindview.util.CountingGenerator;
import net.mindview.util.MapData;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedHashMapTest extends MapTest{
    SynchronizedHashMapTest( int nReaders, int nWriters) {
        super("Synched HashMap", nReaders, nWriters);
    }

    @Override
    Map<Integer, Integer> containerInitializer() {
        return Collections.synchronizedMap(
                new HashMap<>(
                        MapData.map(
                                new CountingGenerator.Integer(),
                                new CountingGenerator.Integer(),
                                containerSize
                        )
                )
        );
    }
}
