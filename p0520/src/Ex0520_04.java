import java.util.Scanner;
public class Ex0520_04 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//두수를 입력받아 큰수와 작은수를 표시하시오
		//큰수:10,작은수:5
		//비교하는 구문은 메소드로 분리하시오
		
		//main 메소드 ->두스를 입력받고
		//compare(num1,num2) 메소들을 만들어라
		
		//static void compare(int num1, int num2)
		
		System.out.println("첫번째 숫자를 입력하세요");
		int num1 = scan.nextInt();
		System.out.println("두번째 숫자를 입력하세요");
		int num2 = scan.nextInt();
		int result = compare(num1,num2);
		if(result == num1) {
			System.out.printf("큰수 :%d , 작은수 :%d",result,num2);
		}else if(result == num2) {
			System.out.printf("큰수 %d , 작은수 :%d",result,num1);
		}else {
			System.out.println("두수가 같습니다.");
		}
	}//main
	
	static int compare(int num1, int num2) {
		int value = 0;
		if(num1>num2) {
			value = num1;
		}
		else if(num1<num2) {
			value = num2;
		}else {
			value = 1;
		}
		return value;
		
	}
}//class
