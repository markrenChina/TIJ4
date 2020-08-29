package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;
public class ex14 {	
		public static void main(String[] args) {
			Tank s1=new Tank();
			Tank s2=new Tank();
			s2=s1;
			System.gc();
		}
}
class Tank{
static int a=1;
static int b;
static {
	b=1;
}
Tank(){
	print("a: "+a+"    b: "+b);
	a=2;
	b=2;
	print("a: "+a+"    b: "+b);
}
protected void finalize() {
	print("finalize±»Ö´ÐÐ£¡");
}
}