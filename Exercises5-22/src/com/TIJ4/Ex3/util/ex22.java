package com.TIJ4.Ex3.util;
import static com.TIJ4.Ex3.util.Print.*;
public class ex22 {	
	public enum notes{
		ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED
	}
	notes degree;
	public ex22(notes degree) {this.degree=degree;}
	public void show() {
		switch(degree) {
		case ONE: print("ONE");break;
		case FIVE: print("FIVE");break;
		case TEN: print("TEN");break;
		case TWENTY: print("TWENTY");break;
		case FIFTY: print("FIFTY");break;
		default:print("HUNDRED");
			break;
		
		}
	}
	public static void main(String[] args) {
		ex22 a=new ex22(notes.HUNDRED);
		ex22 b=new ex22(notes.ONE);
		ex22 c=new ex22(notes.TEN);
		a.show();
		b.show();
		c.show();
	}
}
