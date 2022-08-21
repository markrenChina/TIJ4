package generics;

interface Payable<T> {}

class Employee implements Payable<Employee> {}
//CompileTimeError
//class Hourly extends Employee implements Payable<Hourly>{ }

public class MultipleInterfaceVariants {

}
