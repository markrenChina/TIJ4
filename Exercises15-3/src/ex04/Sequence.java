package ex04;//: innerclasses/Sequence.java
// Holds a sequence of Objects.

interface Selector {
  boolean end();
  Object current();
  void next();
}	

public class Sequence<T> {
  private Object[] items;
  private int next = 0;
  public Sequence(int size) { items = new Object[size]; }

  public static void main(String[] args) {
    Sequence<String> sequence = new Sequence<String>(10);
    for(int i = 0; i < 10; i++)
      sequence.add(Integer.toString(i));
    Selector selector = sequence.selector();
    while(!selector.end()) {
      System.out.print(selector.current() + " ");
      selector.next();
    }
  }

  public void add(T x) {
    if(next < items.length)
      items[next++] = x;
  }

  public Selector selector() {
    return new SequenceSelector();
  }	

  private class SequenceSelector implements Selector {
    private int i = 0;
    public boolean end() { return i == items.length; }
    public T current() { return (T) items[i]; }
    public void next() { if(i < items.length) i++; }
  }
} /* Output:
0 1 2 3 4 5 6 7 8 9
*///:~
