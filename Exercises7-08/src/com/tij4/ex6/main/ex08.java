package com.tij4.ex6.main;

import com.tij4.ex6.test.*;

import static com.tij4.ex6.util.Print.*;
public class ex08 {
	public static void main(String[] args) {
		print("����C����");
		C a=new C(1);
		print("����C����");
		C a2=new C();
	}


}


class A {
	A(int i){print("A������������");}
}


/*class B {
	B(int i){print("B������������");}
}*/
class C extends A{
	int i;
	C(){super(1);
	print("C������������");}
	C(int i){
		super(i);
		this.i=i;
		print("C������������");
		}
}