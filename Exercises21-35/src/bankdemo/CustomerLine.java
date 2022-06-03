package bankdemo;

import java.util.concurrent.ArrayBlockingQueue;

//Teach the customer line to display itself
public class CustomerLine extends ArrayBlockingQueue<Customer> {
    public CustomerLine(int maxLineSzie) {
        super(maxLineSzie);
    }

    @Override
    public String toString() {
        if (this.size() == 0){
            return "[Empty]";
        }
        StringBuilder result = new StringBuilder();
        for(Customer customer : this){
            result.append(customer);
        }
        return result.toString();
    }
}
