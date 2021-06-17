package p0617;

import java.util.Scanner;

public class Ex0617_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("[ 큰수 작은수 확인 프로그램 ]");
			System.out.println("세개의 수를 입력하세요");
			int input1 = sc.nextInt();
			int input2 = sc.nextInt();
			int input3 = sc.nextInt();
			
			int result1 = Math.max(Math.max(input1, input2), input3);
			int result2 = (input1+input2+input3)- (Math.max(Math.max(input1, input2), input3)+Math.min(Math.min(input1, input2), input3));
			int result3 = Math.min(Math.min(input1, input2), input3);
			System.out.printf("큰수 : %d, 중간값: %d, 최소값:%d\n", result1,result2,result3);
//			int result1 = Math.max(input1, input2);
//			int result2 = Math.max(input2, input3);
//			
//			
//			System.out.printf("큰수: %d,작은수: %d\n",result1,result2);
			
		}
	}//main
}//class
