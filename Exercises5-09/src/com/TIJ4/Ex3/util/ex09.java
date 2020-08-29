package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;
public class ex09 {	
		public static void main(String[] args) {
			test s=new test(1);
		}
}
class test{
test() {
	print("无参构造器被执行");
}
test(int i) {
	this();
	print("有参构造器被执行");
}
}