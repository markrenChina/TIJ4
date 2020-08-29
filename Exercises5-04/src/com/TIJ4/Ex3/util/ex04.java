package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;
public class ex04 {	
		public static void main(String[] args) {
			test a=new test();
			test b=new test("haha");
		}
}
class test{
	test(){
		print("无参构造器已经被调用");
	}
	test(String a){
		print("有参构造器已经被调用"+a);
	}
}