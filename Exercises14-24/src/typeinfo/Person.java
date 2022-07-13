package typeinfo;

import net.mindview.util.Null;

public class Person {
    public static final Person NULL = new NullPerson();
    public final String first;
    public final String last;

    //etc.
    public final String address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("first='").append(first).append('\'');
        sb.append(", last='").append(last).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static class NullPerson extends Person implements Null {
        public NullPerson() {
            super("None","None","None");
        }

        @Override
        public String toString() {
            return "NullPerson";
        }
    }
}
