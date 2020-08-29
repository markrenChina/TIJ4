package com.tij4.ex10.main;

import java.util.*;


/*	public class Sequence {	
		private int i;
	  public Sequence(int i) {
			this.i=i;
		}
	  public String toString() {
		  return " "+i;
	  }		  
	public static void main(String[] args) {
	    ArrayList<Sequence> sequence = new ArrayList<Sequence>();
	    for(int i = 0; i < 10; i++)
	      sequence.add(new Sequence(i));
	    for(Sequence s:sequence) System.out.print(s);
	    }
	}
*/
interface Selector {
	  boolean end();
	  Object current();
	  void next();
	  int getI();
	}	

	public class Sequence {
		ArrayList items= new ArrayList();
	  public void add(Object x) {
	    items.add(x);
	  }
	  private class SequenceSelector implements Selector {
	    private int i = 0;
	    public boolean end() { return i == items.size(); }
	    public Object current() { return items.get(i); }
	    public void next() { if(i < items.size()) i++; }
	    public int getI() {
	    	return i;
	    }
	  }
	  public Selector selector() {
	    return new SequenceSelector();
	  }	
	  public static void main(String[] args) {
	    Sequence sequence = new Sequence();
	    for(int i = 0; i < 10; i++)
	      sequence.add(Integer.toString(i));
	    Selector selector = sequence.selector();
	    while(!selector.end()) {
	      System.out.print(selector.current() + " ");
	      selector.next();
	    }
	    //迭代器的i值最后会等于size,并没有重置
	    System.out.println("\n"+"new:");
	    for(int i = 0; i < 10; i++)
		      sequence.add(Integer.toString(i));
	    sequence.add("OVER");
	    System.out.println("迭代器的i="+selector.getI());
	    while(!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	  }
	}