package coucurrency2;

import net.mindview.util.CountingIntegerList;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest extends ListTest{
    CopyOnWriteArrayListTest(int nReaders, int nWriters) {
        super("CopyOnWriteArrayList", nReaders, nWriters);
    }

    @Override
    List<Integer> containerInitializer() {
        return new CopyOnWriteArrayList<>(
                new CountingIntegerList(containerSize)
        );
    }
}
