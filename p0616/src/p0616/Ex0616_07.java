package p0616;

import java.util.Scanner;

public class Ex0616_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//복권 1조12345 -> 0~9까지 가능 
		// 마지막 자리 -> 맞으면 1천원
		// 2자리 -> 1만원
		// 3자리 -> 10만원
		// 4자리 -> 100만원
		// 5자리 -> 1000만원
		// 1번째 랜덤으로 숫자를 생성해서 1조12345 복권번호 생성해 보세요
		// 복권번호 : 9조 45567
		
		int[] arr_lotto = new int[6];
		for(int i=0; i<arr_lotto.length; i++) {
			arr_lotto[i] = (int)(Math.random()*10);
		}
		
//		for(int i=0; i<1000;i++) {
//			int temp = 0;
//			int random_no = (int)(Math.random()*6);
//			temp = arr_lotto[0];
//			arr_lotto[0] = arr_lotto[random_no];
//			arr_lotto[random_no] = temp;
//		}
		int count = 0;
		String lotto = "";
		while(true) {
			if(count ==1) {
				lotto +="조";
			}
			lotto += arr_lotto[count];
			if(count ==5) {
				break;
			}
			count++;
		}
		int count_correct = 0;
		System.out.println("로또번호를 입력하세요");
		String input = sc.next();
		System.out.println(lotto);
//		if(input.substring(0, 2).equals(lotto.substring(0, 2))) {
//			if(input.charAt(6) == lotto.charAt(6)) {
//				if(input.charAt(5) == lotto.charAt(5)) {
//					if(input.charAt(4) == lotto.charAt(4)) {
//						if(input.charAt(3) == lotto.charAt(3)) {
//							if(input.charAt(2) == lotto.charAt(2)) {
//								System.out.println("천만원 당첨");
//								count_correct++;
//							}else {
//								System.out.println("백만원 당첨");
//								count_correct++;
//							}
//						}else {
//							System.out.println("십만원 당첨");
//							count_correct++;
//						}
//					}else {
//						System.out.println("만원당첨");
//						count_correct++;
//					}
//				}else {
//					System.out.println("천원당첨");
//					count_correct++;
//				}
//			}else {
//				System.out.println("백원당첨");
//				count_correct++;
//			}
//			
//		}else {
//			System.out.println("꽝");
//		}
		
		
			if(input.charAt(0)-'0' == lotto.charAt(0)-'0') {
				for(int j=6; j>1; j--) {
					if(lotto.charAt(j)-'0' == input.charAt(j)-'0') {
						count_correct++;
					}else {
						break;
					}
				}
			}
			switch (count_correct) {
			case 0:
				System.out.println("꽝");
				break;
			case 1:
				System.out.println("천원 당첨");
				break;
			case 2:
				System.out.println("만원 당첨");
				break;
			case 3:
				System.out.println("십만원 당첨");
				break;
			case 4:
				System.out.println("백만원 당첨");
				break;
			case 5:
				System.out.println("천만원 당첨");
				break;
				
			default:
				break;
			}
			System.out.println("맞은개수: " + count_correct + "개");
		
	}//main

}//class
