package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;

import java.util.Random;
public class ex10 {

	public static void main(String[] args) {
		int a=0x77;
		int b=0x76;
		print("a="+Integer.toBinaryString(a));
		print("b="+Integer.toBinaryString(b));
		print("a&b="+Integer.toBinaryString(a&b));
		print("a|b="+Integer.toBinaryString(a|b));
		print("a^b="+Integer.toBinaryString(a^b));
		print("~a="+Integer.toBinaryString(~a));
		print("~b="+Integer.toBinaryString(~b));
	}

}
