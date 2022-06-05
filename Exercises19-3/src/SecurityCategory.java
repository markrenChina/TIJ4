import enumerated.Enums;

import java.util.stream.IntStream;

enum SecurityCategory {
    STOCK(Security.Stock.class),BOND(Security.Bond.class);

    Security[] values;

    SecurityCategory(Class<? extends Security> kind) {
        this.values = kind.getEnumConstants();
    }

    public static void main(String[] args) {
        IntStream.range(0,10).forEach(i ->{
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category + ": "+ category.randomSelection());
        });
    }

    public Security randomSelection(){
        return Enums.random(values);
    }

    //Security接口的作用是将其所包含的enum组合成一个公共类型。
    interface Security {
        enum Stock implements Security { SHORT, LONg, MARGIN }
        enum Bond implements Security { MUNICIPAL, JUNK}
    }
}
