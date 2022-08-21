package ex31;

interface Payable {
    void pay();
}

class Employee implements Payable {
    @Override
    public void pay() {
        System.out.println("Employee pay");
    }
}

class Hourly extends Employee implements Payable{
    @Override
    public void pay() {
        super.pay(); //继承优先于接口实现
        System.out.println("Hourly pay");
    }
}

public class Ex31 {

    public static void main(String[] args) {
        Hourly hourly = new Hourly();
        hourly.pay();
    }
}
