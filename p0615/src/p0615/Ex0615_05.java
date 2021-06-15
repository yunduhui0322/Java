package p0615;

public class Ex0615_05 {

	public static void main(String[] args)  {
		method1();
	}//main

	static void method1() {
		try {
			method2();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Holy Moly");
		}
	}
	static void method2() throws Exception{
		throw new Exception();//고의로 예외발생
	}
}//class
