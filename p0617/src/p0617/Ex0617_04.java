package p0617;

public class Ex0617_04 {

	public static void main(String[] args) {
		String str = "aaa";
		System.out.println(System.identityHashCode(str));
		str += "bbb";
		System.out.println(System.identityHashCode(str));
		
		int a= 1;
		System.out.println(System.identityHashCode(a));
		a += 15;
		int b = 16;
		System.out.println(System.identityHashCode(16));

	}//main

}//class
