package com.tij4.ex6.main;

import com.tij4.ex6.test.*;

import static com.tij4.ex6.util.Print.*;
public class ex07 {
	public static void main(String[] args) {
		print("����C����");
		C a=new C(1);
	}


}


class A {
	A(int i){print("A������������");}
}


class B {
	B(int i){print("B������������");}
}
class C extends A{
	int i;
	C(int i){
		super(i);
		this.i=i;
		print("C������������");
		}
	B a=new B(i);
}