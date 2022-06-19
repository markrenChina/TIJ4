package ex19;

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

public class Ex19 {
    public static void main(String[] args) {
        try {
            Ex19 lm = new Ex19();
            try {
                lm.f();
            }catch (Exception e ){
                System.out.println(e);
            } finally{
                lm.dispose();
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
