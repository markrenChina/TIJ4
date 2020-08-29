package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;
public class ex11 {	
		public static void main(String[] args) {
			test s1=new test(1);
			test s2=new test(1);
			s2=s1;
			System.gc();
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
protected void finalize() {
	print("finalize被执行！");
}
}