import java.util.EnumSet;

public class CarWash {

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC,Cycle.RINSE);

    public static void main(String[] args) {
        CarWash wash = new CarWash();
        System.out.println(wash);
        wash.washCar();
        //Order of addition is unimportant
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.BLOWDRY); //Duplicates ignored
        wash.add(Cycle.RINSE);
        wash.add(Cycle.HOTWAX);
        System.out.println(wash);
        wash.washCar();
    }

    public void add(Cycle cycle) { cycles.add(cycle); }
    public void washCar() { cycles.forEach(Cycle::action); }

    @Override
    public String toString() {
        return cycles.toString();
    }

    public enum Cycle {
        UNDERBODY {
            @Override
            void action() {
                System.out.println("Spraying the underbody");
            }
        },
        WHEELWASH {
            @Override
            void action() {
                System.out.println("Washing the wheel");
            }
        },
        PREWASH {
            @Override
            void action() {
                System.out.println("Loosening the dirt");
            }
        },
        BASIC {
            @Override
            void action() {
                System.out.println("The basic wash");
            }
        },
        HOTWAX {
            @Override
            void action() {
                System.out.println("Applying hot wax");
            }
        },
        RINSE {
            @Override
            void action() {
                System.out.println("Rinsing");
            }
        },
        BLOWDRY {
            @Override
            void action() {
                System.out.println("Blowing dry");
            }
        }
        //...
        ;
        abstract void action();
    }
}
