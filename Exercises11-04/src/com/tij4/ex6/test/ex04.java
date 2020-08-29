package com.tij4.ex6.test;

import java.util.*;

interface create{
	int i=0;
	String next();
	public Collection<String> fillAll(Collection c,int n);
}

enum listFilm{
	FILM1,FILM2,FILM3,FILM4,FILM5,FILM6,FILM7,FILM8,FILM9
}

class getFilm implements create{
	int i=0;
	@Override
	public String next() {
		switch(i) {
		case 0: i++;return ""+listFilm.FILM1;
		case 1: i++;return ""+listFilm.FILM2;
		case 2: i++;return ""+listFilm.FILM3;
		case 3: i++;return ""+listFilm.FILM4;
		case 4: i++;return ""+listFilm.FILM5;
		case 5: i++;return ""+listFilm.FILM6;
		case 6: i++;return ""+listFilm.FILM7;
		case 7: i++;return ""+listFilm.FILM8;
		case 8: i=0;return ""+listFilm.FILM9;
		default:;
		}
		return null;
	}
	public Collection<String> fillAll(Collection c,int n) {
		for(int i=0;i<n;i++) {
			c.add(next());
		}
		return c;	
	}
}
public class ex04 {
	public static void main(String[] args) {
		getFilm get=new getFilm();
		System.out.println(get.fillAll(new ArrayList<String>(),11));
		System.out.println(get.fillAll(new LinkedList<String>(),11));
		System.out.println(get.fillAll(new HashSet<String>(),11));
		System.out.println(get.fillAll(new LinkedHashSet<String>(),11));
		System.out.println(get.fillAll(new TreeSet<String>(),11));
	}
}
