
public class storage {

	public static void main(String[] args) {
		int a=0;
		String s="abc";
		a=storage(s);
		System.out.println(a);
	}

	private static int storage(String s) {
		// TODO Auto-generated method stub
		return s.length()*2;
	}

}
