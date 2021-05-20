import java.util.Scanner;

public class Ex0520_03 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		SignData s = new SignData();
		System.out.println("1번째 데이터를 입력하세요.");
		int num1 = scan.nextInt();
		System.out.println("2번째 데이터를 입력하세요");
		int num2 = scan.nextInt();
		System.out.println("사칙연산을 선택하세요.");
		System.out.println("1.더하기, 2.빼기, 3.곱하기, 4.나누기");
		System.out.println("번호를 선택하세요");
		int sign = scan.nextInt();
		double result =  calculation(num1, num2, sign ,s);
		System.out.println("사칙연산 결과값: " + result);
	}// main

	static double calculation(int num1, int num2, int sign, SignData s) {
		double result = 0;
		switch (sign) {
		case 1: // 더하기
			s.strResult = "더하기";
			result = num1 + num2;
			break;
		case 2:// 빼기
			s.strResult = "빼기";
			result = num1 - num2;
			break;
		case 3:// 곱하기
			s.strResult = "나누기";
			result = num1 * num2;
			break;
		case 4:// 나누기
			s.strResult = "빼기";
			result = (double)num1/num2;
			break;
		}
		System.out.println(s.strResult);
		return result;
	}//calculaiton method
}// class
