package com.tij4.ex6.main;

import com.tij4.ex6.test.*;

import static com.tij4.ex6.util.Print.*;
public class ex05 {
	public static void main(String[] args) {
		print("创建C对象");
		C a=new C();
	}


}


class A {
	A(){print("A构造器被调用");}
}


class B {
	B(){print("B构造器被调用");}
}
class C extends A{
	C(){print("C构造器被调用");}
	B a=new B();
}