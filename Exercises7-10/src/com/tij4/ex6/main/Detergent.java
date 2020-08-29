package com.tij4.ex6.main;

import com.tij4.ex6.test.*;

import static com.tij4.ex6.util.Print.*;



class Cleanser {
	  private String s = "Cleanser";
	  public void append(String a) { s += a; }
	  public void dilute() { append(" dilute()"); }
	  public void apply() { append(" apply()"); }
	  public void scrub() { append(" scrub()"); }
	  public String toString() { return s; }
	  public static void main(String[] args) {
	    Cleanser x = new Cleanser();
	    x.dilute(); x.apply(); x.scrub();
	    print(x);
	  }
	} 
/*public class Detergent extends Cleanser {
	  // Change a method:
	  public void scrub() {
	    append(" Detergent.scrub()");
	    super.scrub(); // Call base-class version
	  }
	  // Add methods to the interface:
	  public void foam() { append(" foam()"); }
	  // Test the new class:
	  public static void main(String[] args) {
	    Detergent x = new Detergent();
	    x.dilute();
	    x.apply();
	    x.scrub();
	    x.foam();
	    print(x);
	    print("Testing base class:");
	    Cleanser.main(args);
	  }	
	}*/
public class Detergent{
	private  Cleanser A=new Cleanser();
	public void scrub() {
		append(" Detergent.scrub()");
		A.scrub();
	}
	public void foam() { append(" foam()"); }
	public void append(String a) { A.append(a); }
	public void dilute() { A.dilute(); }
	public void apply() { A.apply(); }
	public String toString() { return A.toString(); }
	public static void main(String[] args) {
	    Detergent x = new Detergent();
	    x.dilute();
	    x.apply();
	    x.scrub();
	    x.foam();
	    print(x);
	    print("Testing base class:");
	    Cleanser.main(args);
}
}