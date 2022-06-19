package exceptions;

//finally 中使用return 遮蔽异常
public class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        }finally {
            //Using 'return' inside the finally block
            //will silence any throw exception
            return;
        }
    }
}
