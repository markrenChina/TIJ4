package com.tij4.ex6.main;

import com.tij4.ex6.test.*;

import static com.tij4.ex6.util.Print.*;
public class ex05 {
	public static void main(String[] args) {
		print("����C����");
		C a=new C();
	}


}


class A {
	A(){print("A������������");}
}


class B {
	B(){print("B������������");}
}
class C extends A{
	C(){print("C������������");}
	B a=new B();
}