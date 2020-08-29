package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;

import java.util.Random;
public class ex14 {

	public static void main(String[] args) {
		String a="123",b="abc",c="123";
		print("123,abc:");
		StringTest(a,b);
		print("123,123");
		StringTest(a,c);
		print("abc,123");
		StringTest(c,b);
	}
	public static void StringTest(String a,String b) {
		print("==:"+(a==b));
		print("!=:"+(a!=b));
		print("equals:"+a.equals(b));
	}
}
