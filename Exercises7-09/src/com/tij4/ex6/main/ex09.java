package com.tij4.ex6.main;

import com.tij4.ex6.test.*;

import static com.tij4.ex6.util.Print.*;
public class ex09 {
	public static void main(String[] args) {
		print("创建Stem对象");
		Stem a2=new Stem();
	}


}


class Root {
	Root(){print("Root构造器被调用");}
	Component1 Component1=new Component1();
	Component2 Component2=new Component2();
	Component3 Component3=new Component3();
}


class Component1 {
	Component1(){print("Component1构造器被调用");}
}
class Component2 {
	Component2(){print("Component2构造器被调用");}
}
class Component3{
	Component3(){print("Component3构造器被调用");}
}
class Stem extends Root{
	Component1 Component1=new Component1();
	Component2 Component2=new Component2();
	Component3 Component3=new Component3();
	Stem(){
	print("Stem构造器被调用");}
	
}