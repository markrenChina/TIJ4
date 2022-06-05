package enumerated;


//Define an enum type
enum Signal { GREEN, YELLOW, RED}

//使用enum构造了一个小型状态机
public class TrafficLight {
    Signal color = Signal.RED;

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7 ; i++){
            System.out.println(t);
            t.change();
        }
    }

    public void change(){
        switch (color){
            //Note that you don't have to say Signal.RED
            //in the case statement
            case RED: color = Signal.GREEN; break;
            case GREEN: color = Signal.YELLOW; break;
            case YELLOW: color = Signal.RED; break;
            //如果case中有return，则必须覆盖default
        }
    }

    @Override
    public String toString() {
        return "TrafficLight{" +
                "color=" + color +
                '}';
    }
}
