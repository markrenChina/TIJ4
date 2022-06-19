package ex30;

class WrapCheckedException {
    void throwRuntimeException(int type){
        try {
            switch (type) {
                case 0: throw new Annoyance();
                case 1: throw new Sneeze();
                case 2: throw new RuntimeException("Where am I?");
                default: return;
            }
        }catch (Exception e){
            //Adapt to unchecked
            throw new RuntimeException(e);
        }
    }
}

class Annoyance extends RuntimeException {
}

class Sneeze extends RuntimeException {
}

public class Human {
    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();
        wce.throwRuntimeException(2);
        wce.throwRuntimeException(1);
        wce.throwRuntimeException(0);
    }
}
