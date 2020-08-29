package com.tij4.ex8.main;
import polymorphism.music.Note;
import static com.tij4.util.Print.*;



class test1 {
	void t1(){t2();}
	void t2(){print("test1 t2 Ö´ÐÐ");}
}	

class test2 extends test1{
	@Override
	void t2() {print("test2 t2 Ö´ÐÐ");};
}



public class ex10 {	
  public static void main(String[] args) {
	  test1 a=new test2();
	  a.t1();
  }
}