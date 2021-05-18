import java.util.Scanner;

public class Ex0518_05 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("두수를 입력하세요");
		
		Ex0518_05 s = new Ex0518_05();
		
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		int result =s.add(num1,num2);
		System.out.println(result);

	}// main method

	//두수를 더해서 리턴해주는 메소드
		int add(int num1, int num2) {
		int result = num1 + num2;

		return result;
	}

}// class
