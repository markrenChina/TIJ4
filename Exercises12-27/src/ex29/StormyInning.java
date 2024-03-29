package ex29;//: exceptions/StormyInning.java
// Overridden methods may throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions.

interface Storm {
  public void event() throws RainedOut;
  public void rainHard() throws RainedOut;
}

class BaseballException extends RuntimeException {}

class Foul extends BaseballException {}

class Strike extends BaseballException {}

abstract class Inning {
  public Inning() throws BaseballException {}
  public void event() throws BaseballException {
    // Doesn't actually have to throw anything
  }
  public abstract void atBat() throws Strike, Foul;
  public void walk() {} // Throws no checked exceptions
}

class StormException extends RuntimeException {}

class RainedOut extends StormException {}

class PopFoul extends Foul {}

public class StormyInning extends Inning implements Storm {
  // OK to add new exceptions for constructors, but you
  // must deal with the base constructor exceptions:
  public StormyInning()
    throws RainedOut, BaseballException {}
  public StormyInning(String s)
    throws Foul, BaseballException {}

  public static void main(String[] args) {
      StormyInning si = new StormyInning();
      si.atBat();
    // Strike not thrown in derived version.
      // What happens if you upcast?
      Inning i = new StormyInning();
      i.atBat();
      // You must catch the exceptions from the
      // base-class version of the method:
  }

  // Regular methods must conform to base class:
//! void walk() throws PopFoul {} //Compile error
  // Interface CANNOT add exceptions to existing
  // methods from the base class:
//! public void event() throws RainedOut {}
  // If the method doesn't already exist in the
  // base class, the exception is OK:
  public void rainHard() throws RainedOut {}

  // You can choose to not throw any exceptions,
  // even if the base version does:
  public void event() {}

  // Overridden methods can throw inherited exceptions:
  public void atBat() throws PopFoul {}
} ///:~
