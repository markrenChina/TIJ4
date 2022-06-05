package enumerated;

import java.util.EnumMap;

import static enumerated.Input.*;

public enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE,CHIPS,SODA,SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private static EnumMap<Input,Category> categories =
            new EnumMap<Input, Category>(Input.class);

    static {
        for (Category enumConstant : Category.class.getEnumConstants()) {
            for (Input type : enumConstant.values) {
                categories.put(type,enumConstant);
            }
        }
    }

    private Input[] values;

    Category(Input... types) {
        values = types;
    }

    public static Category categorize(Input input){
        return categories.get(input);
    }
}
