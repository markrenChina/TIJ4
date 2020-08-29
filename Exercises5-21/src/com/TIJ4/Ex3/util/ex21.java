package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;
public class ex21 {	
	public enum notes{
		ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED
	}

	public static void main(String[] args) {
		for(notes a:notes.values()) {
			print(a+"  "+a.ordinal());
		}
	}
}
