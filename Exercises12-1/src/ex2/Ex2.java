package ex2;

import java.nio.charset.StandardCharsets;

public class Ex2 {

    public static void main(String[] args) {
        String foo = null;
        try {
            foo.getBytes(StandardCharsets.UTF_8);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
