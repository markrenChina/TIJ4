package ex18;

//finally 异常遮蔽了try块异常
class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important exception";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception";
    }
}

public class Ex18 {
    public static void main(String[] args) {
        try {
            Ex18 lm = new Ex18();
            try {
                lm.f();
            }finally {
                try{
                    lm.dispose();
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }
}
