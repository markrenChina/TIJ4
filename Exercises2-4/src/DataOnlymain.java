
public class DataOnlymain {

	public static void main(String[] args) {
		
		class DataOnly{
			int i;
			double d;
			boolean b;
			void printf() {
				System.out.println("i="+i);
				System.out.println("d="+d);
				System.out.println("b="+i);
			}
		}
		DataOnly data=new DataOnly();
		data.i=47;
		data.d=1.1;
		data.b=false;
		data.printf();
	}

}
