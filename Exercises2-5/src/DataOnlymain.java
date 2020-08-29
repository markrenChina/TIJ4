
public class DataOnlymain {
	static int i;
	static double d;
	static boolean b;

	public static void main(String[] args) {
		
		class DataOnly{
			
			void printf() {
				System.out.println("i="+i);
				System.out.println("d="+d);
				System.out.println("b="+i);
			}
		}
		DataOnly data=new DataOnly();
		i=47;
		d=1.1;
		b=false;
		data.printf();
	}

}
