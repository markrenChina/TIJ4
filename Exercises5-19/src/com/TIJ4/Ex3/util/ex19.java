package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;
public class ex19 {	
		public static void main(String[] args) {
			String[] s1=new String[10];
			
			for(int i=0;i<s1.length;i++) {
				s1[i]=""+i+100;
			}
			Tank s2=new Tank();
			s2.f(s1);
			System.gc();
		}
}
class Tank{
Tank(){
}
void f(String... a){
	for(String b:a)
	print("String:"+b);
}
protected void finalize() {
	print("finalize±»Ö´ÐÐ£¡");
}
}