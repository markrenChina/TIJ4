package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;
public class ex05 {	
		public static void main(String[] args) {
			Dog a=new Dog(1,"bbb");
			Dog b=new Dog("haha",2);
		}
}
class Dog{
	Dog(int i,String a){
		print("barking");
	}
	Dog(String a,int i){
		print("howling");
	}
}