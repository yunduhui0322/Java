
public class Ex0520_01 {
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main x :"+d.x);
		
		change(d.x);
		System.out.println("after change main x: " + d.x);
	}//main
	static void change (int x) {
		x = 1000;
		System.out.println("change x :" +x);
	}//change method
}//class
