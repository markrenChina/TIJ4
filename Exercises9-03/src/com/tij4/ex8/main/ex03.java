package com.tij4.ex8.main;



abstract class test{
	test(){
		print();
	}
	abstract void	print();;
}

class test2 extends test{
	private int a=100;
	@Override
	void print() {
		System.out.println(a);
	}
}
 public class ex03 {
  public static void main(String[] args) {
	 test2 a=new test2(); 
	 a.print();
  }}