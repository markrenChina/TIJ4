package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;

import java.util.Random;
public class ex12 {

	public static void main(String[] args) {
		int a=-0x1ff;
		print("a="+Integer.toBinaryString(a));
		a=~a;
		print("a="+Integer.toBinaryString(a));
		a<<=1;
		print("a="+Integer.toBinaryString(a));
		while(a!=0) {
			a>>=1;
			print("a="+Integer.toBinaryString(a));
		}
	}

}
