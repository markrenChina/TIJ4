package com.tij4.ex10.main;
class B{
	class BI{
		BI(int i){
			System.out.println("BI"+i);
		}
	}
}
public class A {
	class AI extends B.BI{
		AI(B b, int i) {
			b.super(i);
			System.out.println("AI"+i);
		}		
	}
	public static void main(String[] args) {
		B b=new B();
		A a=new A();
		A.AI a1=a.new AI(b, 1);
	}

}
