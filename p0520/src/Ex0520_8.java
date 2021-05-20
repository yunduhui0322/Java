import java.util.Scanner;
public class Ex0520_8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 두 수를 입력, sum메소드 호출 return값 출력
		//sum ->두수 사이의 값을 더하여 값을 리턴
		// 1, 100 -> 5050
		
		System.out.println("두수를 입력하세요");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int result =sum(num1,num2); 
		System.out.println(result);
	}//main
	
	static int sum(int a ,int b ){
		int value =0;
		for(int i=a; i<=b; i++) {
			value += i;
		}
		return value;
	}
}//class
