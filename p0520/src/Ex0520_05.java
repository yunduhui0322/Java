import java.util.Scanner;
public class Ex0520_05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//두수를 입력받아 더하기를 해서 결과값을 호출하시오
		// main()-> 두수를 입력,add메소드 호출후 리턴받아 출력
		// add() -> 두수를 더해서 return으로 돌려줌
		// sub() -> 빼기 메소드,multi() 곱하기,deviede() 나누기
		System.out.println("두수를 입력하세요");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int result1 = add(num1,num2);
		int result2 = sub(num1,num2);
		int result3 = multi(num1,num2);
		double result4 = devide(num1,num2);
		System.out.println("두수의 더하기 결과값: " + result1);
		System.out.println("두수의 빼기 결과값: " + result2);
		System.out.println("두수의 곱하기 결과값: " + result3);
		System.out.println("두수의 나누기 결과값: " + result4);
	}//main method
	
	static int add(int a, int b) {
		int	value = a + b; 
		return value;
	}// add method
	
	static int sub(int a , int b) {
		int value = 0;
		if(a>b) {
			value = a-b;
			
		}
		else {
			value = b-a;
		}
		return value;
	}//sub method
	
	static int multi(int a, int b) {
		int value = a*b;
		return value;
	}
	static double devide(int a, int b) {
		double value = (double)a/b;
		return value;
	}
}//class
