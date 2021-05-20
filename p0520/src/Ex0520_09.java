
public class Ex0520_09 {
	
	public static void main(String[] args) {
		MyMath2 mm = new MyMath2();
		mm.a = 200;
		mm.b = 100;
		
		long c = mm.add();
		System.out.println(c);
		
		long d = MyMath2.add(mm.a, mm.b);
		System.out.println(d);
	}//main
}//class
