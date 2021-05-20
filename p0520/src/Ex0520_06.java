import java.util.Scanner;
public class Ex0520_06 {
	public static void main(String[] args) {
		// 실수를 입력받아 -> 반올림 ,올림ceil , floor
		//main() -> 실수입력, myMath 메소드 호출
		Scanner scan = new Scanner(System.in);
		
		System.out.println("실수를 입력하세요");
		double input = scan.nextDouble();
		
		System.out.println("1. 반올림 , 2. 올림, 3. 버림");
		
		int insert = scan.nextInt();
		long result =(long)myMath(input,insert);
		
		System.out.println(result);
	
	}//main method
	
	static double myMath(double a, int b) {
		
		double result = 0;
		
		switch (b) {
		case 1:
			result = Math.round(a);
			break;
		case 2:
			result = Math.ceil(a);
			break;
		case 3:
			result = Math.floor(a);
			break;

		}
		
		return result;
	}
}// class
