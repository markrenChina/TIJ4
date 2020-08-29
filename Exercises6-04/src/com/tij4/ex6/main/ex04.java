package com.tij4.ex6.main;

import com.tij4.ex6.test.test;

public class ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test2 a=new test2();
		a.show2();
		test b=new test();
		//b.show();
	}

}
class test2 extends test {
public void show2() {
	show();
}
}