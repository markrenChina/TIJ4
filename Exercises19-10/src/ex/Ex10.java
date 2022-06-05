package ex;

import enumerated.Category;
import enumerated.FileInputGenerator;
import enumerated.Input;
import enumerated.RandomInputGenerator;
import net.mindview.util.Generator;

import java.util.EnumMap;

import static ex.Ex10.State.*;

interface handler{
    default void next(Input input){
        throw new RuntimeException("Only call next(Input input) for "
                + "non-transient states" );
    }
    default void next(){
        throw new RuntimeException("Only call next() for "
                + "StateDuration.TRANSIENT states" );
    }
    default void output(int amount){
        System.out.println(amount);
    }
}

public class Ex10 {

    private State state = State.RESTING;
    private EnumMap<State,handler> enumMap = new EnumMap<State, handler>(State.class);
    private int amount = 0;
    private Input selection = null;
    public Ex10() {
        enumMap.put(State.RESTING, new handler() {
            @Override
            public void next(Input input) {
                switch (Category.categorize(input)){
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        });
        enumMap.put(ADDING_MONEY, new handler() {
            @Override
            public void next(Input input) {
                switch (Category.categorize(input)){
                    case MONEY:
                        amount += input.amount();
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount()){
                            System.out.println("Insufficient money for" + selection);
                        }else {
                            state = DISPENSING;
                        }
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        });
        enumMap.put(DISPENSING, new handler() {
            @Override
            public void next() {
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        });
        enumMap.put(GIVING_CHANGE, new handler() {
            @Override
            public void next() {
                if (amount > 0){
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        });
        enumMap.put(TERMINAL, new handler() {
            @Override
            public void output(int a) {
                System.out.println("Halted");
            }
        });
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        if (args.length == 1){
            gen = new FileInputGenerator(args[0]);
        }
        Ex10 ex10 = new Ex10();
        ex10.run(gen);
    }

    //不会再瞬时状态停留
    void run(Generator<Input> generator){
        while (state != TERMINAL){
            enumMap.get(state).next(generator.next());
            while (state.isTransient){
                enumMap.get(state).next();
            }
            enumMap.get(state).output(amount);
        }
    }

    enum StateDuration { TRANSIENT } // Tagging enum

    //对于每一个State，我们都需要在输入动作的基本分类中进行查找
    enum State {
        RESTING,
        ADDING_MONEY,
        //瞬时状态
        DISPENSING(StateDuration.TRANSIENT),
        GIVING_CHANGE(StateDuration.TRANSIENT),
        TERMINAL;
        private boolean isTransient = false;
        State(){}
        State(StateDuration trans) { isTransient = true;}
    }
}
