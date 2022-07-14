package util;

//name pair better
public class TwoTuple <A,B>{
    //final 配置public 对于不可变对象来说，更简洁
    //想要更改时必须重新创建新的对象
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
