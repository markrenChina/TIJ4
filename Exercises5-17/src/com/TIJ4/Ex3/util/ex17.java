package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;
public class ex17 {	
		public static void main(String[] args) {
			Tank[] s1=new Tank[10];
			
			System.gc();
		}
}
class Tank{
Tank(String a){
	print("String: "+a);
}
protected void finalize() {
	print("finalize±»Ö´ÐÐ£¡");
}
}