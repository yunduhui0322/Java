
import java.util.Scanner;
public class Ex0520_07 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//두수를 입력받아  결과값을 출력->cal() 메소드 호출
		//cal() -> 더하기,빼기,곱하기,나누기를 해서 리턴받음.
			
		SignData s = new SignData();
		System.out.println("첫번째 숫자를 입력하세요");
		s.num1 = scan.nextInt();
		System.out.println("두번째 숫자를 입력받으세요");
		s.num2 = scan.nextInt();
		cal(s);
		
		
		System.out.printf("더하기:%d , 빼기 :%d , 곱하기 : %d , 나누기 :%f",s.result1,s.result2,s.result3,s.result4);
	}//main
	
	static void cal(SignData s) {
		s.result1 = s.num1 + s.num2;
		s.result2 = s.num1 - s.num2;
		s.result3 = s.num1 * s.num2;
		s.result4 = (double)s.num1/s.num2;
				
		
	}
}//class
