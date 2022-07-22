package ex19;

import net.mindview.util.Generator;

import java.util.Random;

public class Product {
    public static Generator<Product> generator = new Generator<Product>() {
        private Random rand = new Random(47);

        @Override
        public Product next() {
            return new Product(rand.nextInt(), "Test",Math.round(
                    rand.nextDouble() * 1000.0 + 0.99
            ));
        }
    };
    private final int id;
    private String description;
    private double price;

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public void priceChange(double change){
        price+=change;
    }
}
