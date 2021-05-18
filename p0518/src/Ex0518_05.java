import java.util.Scanner;

public class Ex0518_05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("두수를 입력하세요");

		int num1 = scan.nextInt();
		int num2 = scan.nextInt();

		System.out.println(max(num1, num2));

	}// main method

	static int max(int num1, int num2) {
		int result = 0;// 결과값
		if (num1 > num2) {
			result = num1;
		} else {
			result = num2;
		}

		return result;
	}

}// class
