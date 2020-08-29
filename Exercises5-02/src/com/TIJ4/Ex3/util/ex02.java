package com.TIJ4.Ex3.util;
public class ex02 {	
		public static void main(String[] args) {
			test a=new test();
			System.out.println(a.a);
			System.out.println(a.b);
		}
}
class test{
	
	String a="aaa";
	String b;
	test(){
		b="bbb";
	}
}