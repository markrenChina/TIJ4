package ex20;//: exceptions/exceptions.StormyInning.java
// Overridden methods may throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions.

interface Storm {
  public void event() throws RainedOut;
  public void rainHard() throws RainedOut;
}

class BaseballException extends Exception {}

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

class StormException extends Exception {}

class RainedOut extends StormException {}

class PopFoul extends Foul {}

class UmpireArgument extends Exception {}

public class Ex20 extends Inning implements Storm {
  // OK to add new exceptions for constructors, but you
  // must deal with the base constructor exceptions:
  public Ex20()
    throws RainedOut, BaseballException {}
  public Ex20(String s)
    throws Foul, BaseballException {}

  public static void main(String[] args) {
    try {
      Ex20 si = new Ex20();
      si.atBat();
      si.f();
    } catch(PopFoul e) {
      System.out.println("Pop foul");
    } catch(RainedOut e) {
      System.out.println("Rained out");
    } catch(BaseballException e) {
      System.out.println("Generic baseball exception");
    } catch (UmpireArgument e) {
      System.out.println("UmpireArgument exception");
    }
    // exceptions.Strike not thrown in derived version.
    try {
      // What happens if you upcast?
      Inning i = new Ex20();
      i.atBat();
      // You must catch the exceptions from the
      // base-class version of the method:
    } catch(Strike e) {
      System.out.println("exceptions.Strike");
    } catch(Foul e) {
      System.out.println("exceptions.Foul");
    } catch(RainedOut e) {
      System.out.println("Rained out");
    } catch(BaseballException e) {
      System.out.println("Generic baseball exception");
    }
  }

  // Regular methods must conform to base class:
//! void walk() throws exceptions.PopFoul {} //Compile error
  // Interface CANNOT add exceptions to existing
  // methods from the base class:
//! public void event() throws exceptions.RainedOut {}
  // If the method doesn't already exist in the
  // base class, the exception is OK:
  public void rainHard() throws RainedOut {}
  // Overridden methods can throw inherited exceptions:

  // You can choose to not throw any exceptions,
  // even if the base version does:
  public void event() {}

  public void f() throws UmpireArgument {

  }

  public void atBat() throws PopFoul {}
} ///:~
