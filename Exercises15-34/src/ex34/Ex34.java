package ex34;


abstract class Demo<T extends Demo<T>>{
    abstract T getT(T arg) ;
    void printClassName(){
        System.out.println(getT((T) this).getClass().getSimpleName());
    }
}

class Test1 extends Demo{

    @Override
    Demo getT(Demo arg) {
        return arg;
    }
}

class Test2 extends Demo<Test2>{
    @Override
    Test2 getT(Test2 arg) {
        return arg;
        //return new Test1();
    }
}

public class Ex34 {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.printClassName();
        new Test2().printClassName();
    }
}
