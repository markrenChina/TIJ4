package com.tij4.ex6.main;

import com.tij4.ex6.test.*;

import static com.tij4.ex6.util.Print.*;

import java.nio.charset.MalformedInputException;




public class Frog extends Amphibian{
	public void show(Frog a){print("Frog"
			+ "������ִ��");}
	public static void main(String[] args) {
		Frog a =new Frog();
		Amphibian b=new Amphibian();
		b.show(a);
		a.show(a);
		a.show2();
	}
}
class Amphibian{
	public void show(Amphibian a) {print("Amphibian������ִ��");}
	void show2() {print("Amphibian show2������ִ��");}
}