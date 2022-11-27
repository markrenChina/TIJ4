package ex;

import containers.CountedString;

import java.util.Objects;

class CountedString2 extends CountedString{

    char c;

    public CountedString2(String s) {
        super(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CountedString2 that = (CountedString2) o;
        return c == that.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), c);
    }
}

public class Ex26 {


}
