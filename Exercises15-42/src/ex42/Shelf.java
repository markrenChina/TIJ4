package ex42;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private final Integer space;

    private List<Goods> goodsList = new ArrayList<>();

    public Shelf(Integer space) {
        this.space = space;
    }
}
