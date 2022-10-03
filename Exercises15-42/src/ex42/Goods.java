package ex42;

public class Goods {
    private final Integer price;
    private final Integer quantity;

    public Goods(Integer price) {
        this(price,0);
    }

    public Goods(Integer price, Integer quantity) {
        this.price = price;
        this.quantity = quantity;
    }
}
