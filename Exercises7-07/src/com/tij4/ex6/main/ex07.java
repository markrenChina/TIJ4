package com.tij4.ex6.main;

import com.tij4.ex6.test.*;

import static com.tij4.ex6.util.Print.*;
public class ex07 {
	public static void main(String[] args) {
		print("创建C对象");
		C a=new C(1);
	}


}


class A {
	A(int i){print("A构造器被调用");}
}


class B {
	B(int i){print("B构造器被调用");}
}
class C extends A{
	int i;
	C(int i){
		super(i);
		this.i=i;
		print("C构造器被调用");
		}
	B a=new B(i);
}