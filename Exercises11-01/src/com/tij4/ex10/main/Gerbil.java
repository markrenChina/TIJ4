package com.tij4.ex10.main;

import java.util.ArrayList;

public class Gerbil {
	int gerbilNumber;
	Gerbil(int gerbilNumber){
		this.gerbilNumber=gerbilNumber;
	}
	void hop(){
		System.out.println("Gerbil "+gerbilNumber+" hops");
	}
	public static void main(String[] args) {
		ArrayList<Gerbil> arrayGerbil=new ArrayList<Gerbil>();
		for(int i=1;i<10;i++) arrayGerbil.add(new Gerbil(i));
		for(int i=0;i<9;i++) arrayGerbil.get(i).hop();
	}

}
