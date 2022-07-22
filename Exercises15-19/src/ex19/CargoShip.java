package ex19;

public class CargoShip {
    private Cabin cabin;

    public CargoShip(Cabin cabin) {
        this.cabin = cabin;
    }

    public static void main(String[] args) {
        System.out.println(new CargoShip(new Cabin(10,20)));
    }

    @Override
    public String toString() {
        return "CargoShip{" +
                "cabin=" + cabin +
                '}';
    }
}
