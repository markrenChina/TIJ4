package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;

import java.util.Random;
public class throwIcon {

	public static void main(String[] args) {
		Icon a=new Icon();
		print(a.throwone());
	}

}
class Icon{
	boolean result;
	public boolean throwone() {
		Random rand=new Random();
		if(rand.nextInt(2)==0)
		return result=false;
		else {
			return result=true;
		}
	}
	
}