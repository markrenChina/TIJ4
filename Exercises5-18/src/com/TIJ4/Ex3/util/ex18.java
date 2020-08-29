package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;
public class ex18 {	
		public static void main(String[] args) {
			Tank[] s1=new Tank[10];
			for(int i=0;i<s1.length;i++) {
				s1[i]=new Tank(""+i);
			}
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