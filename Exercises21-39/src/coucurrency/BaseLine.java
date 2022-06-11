package coucurrency;

public class BaseLine extends Accumulator{
    {
        id = "BaseLine";
    }

    @Override
    public void accumulate() {
        int i = index;
        if (i >= SIZE) i =0;
        value += preLoaded[i++];
    }

    @Override
    public long read() {
        return value;
    }
}
