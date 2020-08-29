package com.tij4.ex9.main;
import static  com.tij4.util.Print.*;

public class Apply {
	public static void process(Processor p, Object s) {
	    print("Using Processor " + p.name());
	    print(p.process(s));
	}
}
