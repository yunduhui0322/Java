package pack01;

import java.util.Scanner;

public class Ex0527_01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Buyer b = new Buyer();
		while(true) {
			System.out.println("[ 쇼핑몰 프로그램 ]");
			System.out.println("1. 맥북노트북 구매");
			System.out.println("2. 아이폰 구매");
			System.out.println("3. OLEDTV 구매");
			System.out.println("4. 금액충전");
			System.out.println("5. 구매목록 보기");
			System.out.println("구매하실 번호를 입력하세요");
			
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				b.buy(new Computer());
				break;
			case 2:
				b.buy(new SmartPhone());
				break;
			case 3:
				b.buy(new Tv());
				break;
			case 4://얼마충전 결제는 카드? 현금?
				System.out.println("충전하실 금액을 입력하세요(0.상위메뉴 이동)");
				System.out.printf("현재금액 :%d만원\n",b.getMy_money());
				int input_money = scan.nextInt();
				if(input_money == 0) {
					System.out.println("상위메뉴로 이동합니다");
					break;
				}
				b.setMy_money(input_money);
				break;
			case 5:
				b.buy_cart();
				break;
			default:
				System.out.println("잘못 입력하셨습니다");
				break;
			}
		}
		
		
		
		
		
//		Product p = new Product();
//		System.out.println("이름을 입력하세요");
//		String name = scan.next();
//		p.setPro_name(name);
//		p.setPrice(100);
//		p.setBonusPoint(50);
//		System.out.printf("이름 : %s, 가격: %d, 보너스 포인트: %.0f",p.getPro_name(),p.getPrice(),p.getBonusPoint());
	}//main
}//class
