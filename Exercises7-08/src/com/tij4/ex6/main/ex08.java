package com.tij4.ex6.main;

import com.tij4.ex6.test.*;

import static com.tij4.ex6.util.Print.*;
public class ex08 {
	public static void main(String[] args) {
		print("创建C对象");
		C a=new C(1);
		print("创建C对象");
		C a2=new C();
	}


}


class A {
	A(int i){print("A构造器被调用");}
}


/*class B {
	B(int i){print("B构造器被调用");}
}*/
class C extends A{
	int i;
	C(){super(1);
	print("C构造器被调用");}
	C(int i){
		super(i);
		this.i=i;
		print("C构造器被调用");
		}
}