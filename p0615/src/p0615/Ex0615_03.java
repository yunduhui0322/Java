package p0615;

import java.util.Scanner;

public class Ex0615_03 {

	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		int[] a = new int [10];
		int count = 0;
		while(true) {
			System.out.println("시작하려면 아무키를 누르세요>>");
//			sc.next();
			
			System.out.println("1번실행");
			System.out.println("2번실행");
			try {
				a[count] = sc.nextInt();
				System.out.println("3번 실행");
				System.out.println(0/0);
				System.out.println("4번 실행");
//				Exception e = new Exception("고의로 발생시킴");
//				throw e;
			} catch (ArithmeticException e) {
//				e.printStackTrace();//예외가 어디에서 일어낳는지 보여줌
//				System.out.println(e.getMessage());
				System.out.println("0으로나눈 에러입니더");
				System.out.println("5번실행");
				System.out.println("예외처리를 해서 프로그램을 다시 시작합니다.");
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("이 예외가 발생시 배열 10개를 늘려줌.");
			}finally {
				System.out.println("무조건무조건이야");
			}
			System.out.println("6번실행");
			count++;
		}//while 
		
//		System.out.println("3번실행");
//		System.out.println(0/0);
//		System.out.println("4번실행");
//		System.out.println("5번실행");
//		System.out.println("6번실행");
//		
		
//		try {
//			System.out.println(0/0);
//			System.out.println("4번실행");
//		} catch (Exception e) {
//			System.out.println("5번실행");
//		}
//		System.out.println("6번실행");
	}//main

}//class
