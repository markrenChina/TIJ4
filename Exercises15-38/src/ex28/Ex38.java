package ex28;

class Coffee {
    void drink() {
        System.out.println( "drink "+ this);
    }

    @Override
    public String toString() {
        return "Coffee";
    }
}

abstract class DecoratorCoffee extends  Coffee{

    protected final Coffee coffee;
    String status;

    public DecoratorCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String toString() {
        return status + " " +coffee.toString();
    }
}

class ChocolateCoffee extends DecoratorCoffee {

    public ChocolateCoffee(Coffee coffee) {
        super(coffee);
        status = "Chocolate";
    }
}
class PuffCoffee extends DecoratorCoffee {

    public PuffCoffee(Coffee coffee) {
        super(coffee);
        status = "Puff";
    }
}
class MilkCoffee extends DecoratorCoffee {

    public MilkCoffee(Coffee coffee) {
        super(coffee);
        status = "Milk";
    }
}

public class Ex38 {

    public static void main(String[] args) {
        Coffee myCoffee = new MilkCoffee(new ChocolateCoffee(
                new PuffCoffee( new MilkCoffee(
                        new ChocolateCoffee(new Coffee())
                ))
        ));
        myCoffee.drink();
    }
}
