import java.util.Arrays;

public enum OverrideConstantSpecific {
    NUT,BOLT,
    WASHER {
        void f() {
            System.out.println("Override method");
        }
    };
    public static void main(String[] args) {
        Arrays.stream(values()).forEach(e -> {
            System.out.println(e + ": ");
            e.f();
        });
    }

    void f() {
        System.out.println("default behavior");
    }
}
