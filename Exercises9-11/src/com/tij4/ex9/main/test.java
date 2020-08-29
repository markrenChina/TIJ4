package com.tij4.ex9.main;

public class test implements Processor {
	public String name() {
		return " test";
	}
	test t;
	public void testAdapter(test t) {this.t=t;}	
	public String process(Object input) {
		return process1((String)input);
	}
	static test process1(String s) {
		char[] ca = new char[s.length()];
		if((s.length())%2 == 0) {
		for(int i = 0; i < s.length(); i += 2) {
		ca[i] = s.charAt(i + 1);
		ca[i + 1] = s.charAt(i);			
		}		
		return new String(ca);
		}
		else {
		for(int i = 0; i < s.length() - 1; i += 2) {
		ca[i] = s.charAt(i + 1);
		ca[i + 1] = s.charAt(i);			
		}
		ca[s.length() - 1] = s.charAt(s.length() - 1);		
		return new String(ca);
		}
}
	public static void main(String[] args) {
		String s = new String(args[0]);
		test b=new test();
		Apply.process(b.testAdapter(b.process1(s)), s);
	}
}
	
