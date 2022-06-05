
//对于enum而言，实现接口是实现其子类化的唯一办法
//嵌入Food中的每个enum都实现了Food接口
public interface Food {
    enum Appetizer implements Food {
        SALAD,SOUP,SPRING_ROLLS;
    }
    enum MainCourse implements Food {
        LASAGNE,BURRITO,PAD_THAI,
        LENTILS,HUMMOUS,VINDALOO;
    }
    enum Dessert implements Food {
        TIRAMISU, FELATO, BLACK_FOREST_CAKE,
        FRUIT,CREME_CARAMEL;
    }
    enum Coffee implements Food {
        BLACK_COFFEE,DECAF_COFFEE,ESPRESSO,
        LATTE,CAPPUCCINO,TEA,HERB_TEA;
    }
}
