package com.tij4.ex10.main;

import java.util.*;

public class simpleCollection {
	
	public static void main(String[] args) {
		Collection<Integer> c=new HashSet<Integer>();
		for(int i=0;i<10;i++) c.add(i);
		for(Integer i:c)System.out.print(i+", ");
	}

}
