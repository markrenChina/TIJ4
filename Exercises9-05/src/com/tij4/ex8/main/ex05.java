package com.tij4.ex8.main;
import com.tij4.ex6.test.*;


public class ex05 implements test {
	@Override
	public String intChangeString(int a) {
		// TODO Auto-generated method stub
		return a+"";
	}
	@Override
	public  void print(Object obj) {
		// TODO Auto-generated method stub
		System.out.println(obj);
	}
	@Override
	public int stringChangeInt(String a) {
		// TODO Auto-generated method stub
		return Integer.parseInt(a);
	}
	public static void main(String[] args) {
		int a=123;
		ex05 b=new ex05(); 
		b.print(a);
		b.intChangeString(a);
		int c=b.stringChangeInt(b.intChangeString(a));
		b.print(c);
	}
}