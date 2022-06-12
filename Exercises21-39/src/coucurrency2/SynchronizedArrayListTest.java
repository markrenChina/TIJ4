package coucurrency2;

import net.mindview.util.CountingIntegerList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedArrayListTest extends ListTest {
    SynchronizedArrayListTest( int nReaders, int nWriters) {
        super("Synched ArrayList", nReaders, nWriters);
    }

    @Override
    List<Integer> containerInitializer() {
        return Collections.synchronizedList(
                new ArrayList<>(
                        new CountingIntegerList(containerSize)
                )
        );
    }
}
