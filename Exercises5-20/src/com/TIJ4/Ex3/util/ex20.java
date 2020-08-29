package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;
public class ex20 {	
		public static void main(String[] args) {
			Tank.main("a","b","c");
			Tank.main((Object)1,(Object)2,(Object)3,(Object)4,(Object)5,(Object)6);
		}
}
class Tank{
public static void main(Object... args) {
	for(Object c:args) {
		print(c);
	}
}
}