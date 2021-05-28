package pack01;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex0528_01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Process01 p = new Process01();
		
		while(true) {
			
			
			System.out.println("[ 프로그램 ]");
			System.out.println("1. 두수의 합");
			System.out.println("2. 두수 사이의 합");
			System.out.println("3. 두수의 크기 비교");
			System.out.println("원하는 번호를 입력하세요");
			
			int choice = scan.nextInt();
			
			switch (choice) {
			case 1:
//				int result = p.plus(a, b);
	
				System.out.println("두수의 합:"+p.plus(p.number_input()));
				System.out.println("두수의 합:"+p.plus1(p.number_input2()));
				break;
			case 2:
				
				System.out.println("두수의 사이의 합:"+p.sum(p.number_input()));
				System.out.println("두수의 사이의 합:"+p.sum2(p.number_input2()));
//				int result1 = p.sum(a1, b2);
				
			case 3:
				int[]a  = p.number_input2();
				p.size(a);
				ArrayList<Integer>b = p.number_input();
				p.size1(b);
				break;

			default:
				break;
			}
		}//while
	}//main

}//class
