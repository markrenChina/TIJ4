package enumerated;

import net.mindview.util.Generator;

public class VendingMachine {

    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;

    //不会再瞬时状态停留
    static void run(Generator<Input> generator){
        while (state != State.TERMINAL){
            state.next(generator.next());
            while (state.isTransient){
                state.next();
            }
            state.output();
        }
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        if (args.length == 1){
            gen = new FileInputGenerator(args[0]);
        }
        run(gen);
    }

    enum StateDuration { TRANSIENT } // Tagging enum

    //对于每一个State，我们都需要在输入动作的基本分类中进行查找
    enum State {
        RESTING {
            @Override
            void next(Input input) {
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
        },
        ADDING_MONEY { //用户塞入钞票
            @Override
            void next(Input input) {
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
        },
        //瞬时状态
        DISPENSING(StateDuration.TRANSIENT){
            void next() {
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT){
            void next() {
                if (amount > 0){
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL { //机器停止
            @Override
            void output() {
                System.out.println("Halted");
            }
        };
        private boolean isTransient = false;
        State(){}
        State(StateDuration trans) { isTransient = true;}
        void next(Input input){
            throw new RuntimeException("Only call next(Input input) for "
                    + "non-transient states" );
        }
        void next(){
            throw new RuntimeException("Only call next() for "
                    + "StateDuration.TRANSIENT states" );
        }
        void output(){
            System.out.println(amount);
        }
    }
}
