package ex25.d;

final class HD {
    private final double aDouble= 2020.0;
    private int intValue = 1024;
    private float aFloat = 3.14F;

    public HD() {
    }

    private int getIntValue() {
        return intValue;
    }

    private float getaFloat() {
        return aFloat;
    }
}

public class D {
    public static HD makeD(){ return new HD(); }
}
