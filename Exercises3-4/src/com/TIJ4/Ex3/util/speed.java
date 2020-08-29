package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;
public class speed {

	public static void main(String[] args) {
		Tank t1=new Tank();
		Tank t2=new Tank();
		t1.level=9.9f;
		t2.level=47.8f;
		print("1:t1.level: "+t1.level+"   t2.level: "+t2.level);
		t1=t2;
		print("2:t1.level: "+t1.level+"   t2.level: "+t2.level);
		t1.level=27.4f;
		print("3:t1.level: "+t1.level+"   t2.level: "+t2.level);
	}

}
class Tank{
	float level;
}