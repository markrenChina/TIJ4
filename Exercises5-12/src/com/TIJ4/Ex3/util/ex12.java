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
	print("���󱻴���");
}
protected void finalize() {
	empty=true;
	print("finalize��ִ�У�empty is "+empty);
}
}