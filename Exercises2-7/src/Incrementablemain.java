
public class Incrementablemain {
	static class StaticTest{
		static int i=47;
	}
	static class Incrementable{
		static void increment() {
			StaticTest.i++;
		}
	}
	public static void main(String[] args) {
		
		StaticTest st1=new StaticTest();
		StaticTest st2=new StaticTest();
		StaticTest.i++;
		System.out.println("str1="+st1.i);
		System.out.println("str2="+st2.i);
		Incrementable.increment();
		System.out.println("increment str1="+st1.i);
		System.out.println("increment str2="+st2.i);
		Incrementable sf =new Incrementable();
		sf.increment();
		System.out.println("sf.increment str1="+st1.i);
		System.out.println("sf.increment str2="+st2.i);
		
	}

}
