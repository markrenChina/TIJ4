import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

//通常被称为表驱动的代码，在调用时提现出多态的行为
public enum ConstantSpecificMethod {
    DATE_TIME {
        String getInfo(){
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo(){
            return System.getenv("CLASSPATH");
        }
    },
    Version {
        String getInfo(){
            return System.getProperty("java.version");
        }
    };
    public static void main(String[] args) {
        Arrays.stream(values()).forEach(e -> {
            System.out.println(e.getInfo());
        });
    }

    abstract String getInfo();
}
