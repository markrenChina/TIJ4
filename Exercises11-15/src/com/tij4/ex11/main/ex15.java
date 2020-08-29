package com.tij4.ex11.main;

import java.util.LinkedList;

public class ex15 {
	
	public static void main(String[] args) {
		String src = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
		Stack<Character> s = new Stack<Character>();
		for(int i = 0 ; i < src.length(); i ++){
			char c = src.charAt(i);
			if(c == '+') {
				s.push(src.charAt(i + 1));
				i++;
			}else if(c == '-'){
				System.out.println(s.pop().toString());;
			}
		}
	}
}
