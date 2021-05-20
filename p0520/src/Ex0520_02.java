
public class Ex0520_02 {
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main : "+d.x);
		
		change(d);
		System.out.println("After change x : "+d.x);
	}//main
	
	static void change(Data d) {
		d.x = 1000;
		System.out.println("change x : "+d.x);
	}//change method
}//class
