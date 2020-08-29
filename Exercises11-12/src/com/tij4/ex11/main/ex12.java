package com.tij4.ex11.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import static com.tij4.util.Print.*;

public class ex12 {

	public static void main(String[] args) {
		List<Integer> intList1 = new LinkedList<Integer>();
		for(int i =1 ; i < 10 ; i++) {
			intList1.add(new Integer(i));
		}
		ListIterator<Integer> it1 = intList1.listIterator();
		while(it1.hasNext()) {
			print(it1.next().toString());
		}
		List<Integer> intList2 = new LinkedList<Integer>();
		while(it1.hasPrevious()) {
			Integer i = it1.previous();
			intList2.add(i);
		}
		ListIterator<Integer> it2 = intList2.listIterator();
		print("**************************");
		while(it2.hasNext()) {
			Integer i = it2.next();
			print(i.toString());
		}
	}

}
