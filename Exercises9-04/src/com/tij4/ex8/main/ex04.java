package com.tij4.ex8.main;


abstract class Dad {
}

class Son extends Dad {
	protected void print() { System.out.println("Son"); }
}

abstract class SecondDad {
	abstract protected void print();
}

class SecondSon extends SecondDad {
	protected void print() { System.out.println("SecondSon"); }
}

public class ex04 {
	public static void testPrint(Dad d) {
		((Son)d).print();
	}
	public static void secondTestPrint(SecondDad sd) {
		sd.print();
	}
	public static void main(String[] args) {
		Son s = new Son();
		ex04.testPrint(s);
		SecondSon ss = new SecondSon();
		ex04.secondTestPrint(ss);			
	}
}