package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;
public class ex12 {	
		public static void main(String[] args) {
			Tank s1=new Tank();
			Tank s2=new Tank();
			s2=s1;
			System.gc();
		}
}
class Tank{
boolean empty;
Tank(){
	print("对象被创建");
}
protected void finalize() {
	empty=true;
	print("finalize被执行！empty is "+empty);
}
}