package strings;

import java.util.Formatter;

public class Receipt {
    private  final int itemWidth;
    private  final int qtyWidth;
    private  final int priceWidth;
    private double total = 0;
    private Formatter f = new Formatter(System.out);

    public Receipt(int itemWidth, int qtyWidth, int priceWidth) {
        this.itemWidth = itemWidth;
        this.qtyWidth = qtyWidth;
        this.priceWidth = priceWidth;
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt(15,5,10);
        receipt.printTitle();
        receipt.print("Jack's Magic Beans",4,4.25);
        receipt.print("Princess Peas",3,5.1);
        receipt.print("Three Bears Porridge",1,14.29);
        receipt.printTotal();
    }

    public void printTitle() {
        String formatStr = "%-"+itemWidth +"s %"+qtyWidth+"s %"+priceWidth+"s%n";
        f.format(formatStr,"Item","Qty","Price");
        f.format(formatStr,"----","---","-----");
    }

    public void print(String name, int qty, double price){
        String formatStr = "%-"+itemWidth+"."+itemWidth +"s %"+qtyWidth+"d %"+priceWidth+".2f%n";
        f.format(formatStr,name ,qty ,price);
        total+=price;
    }

    public void printTotal(){
        String formatStr = "%-"+itemWidth +"s %"+qtyWidth+"s %"+priceWidth+"s%n";
        String formatFloat = "%-"+itemWidth +"s %"+qtyWidth+"s %"+priceWidth+".2f%n";
        f.format(formatFloat,"Tax","",total*0.06);
        f.format(formatStr,"","","-----");
        f.format(formatFloat,"Total","",total*1.06);
    }
}
