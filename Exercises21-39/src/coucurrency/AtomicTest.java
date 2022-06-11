package coucurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicTest extends Accumulator{
    private AtomicInteger index = new AtomicInteger(0);
    private AtomicLong value = new AtomicLong(0L);

    { id = "Atomic"; }

    @Override
    public void accumulate() {
        //Oops! Relying on more than one Atomic at
        //a time doesn't work. But it still gives us
        //a performance indicator
       int i = index.getAndIncrement();
       value.getAndAdd(preLoaded[i%SIZE]);
       if (++i == SIZE ){
           index.addAndGet(-SIZE);
       }
    }

    @Override
    public long read() {
        return value.get();
    }
}
