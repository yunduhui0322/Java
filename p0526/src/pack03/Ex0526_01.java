package pack03;

import java.util.Scanner;

public class Ex0526_01 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
//	조상 : Product 
//	자손 : Refrigerator- "비스포크" 300
//	Washer - "트럼" 180
//	Conditioner - "무풍" 230
//	Styler - "스타일러" 130
//	초기보유금액 - 2000
//	구매물품  - 비스포크 2대, 트럼 3대 , 무풍 1대, 스타일러2대
//	총 구매금액 출력, 총 구매 개수 출력, 총구매목록 출력
		
		Buyer b = new Buyer();
		
		l1:while(true) {
			System.out.println("[ 구매 목록 ]");
			System.out.println("1. 장바구니에 담기");
			System.out.println("2. 장바구니에서 구매하기");
			System.out.println("3. 구매하기");
			System.out.println("4. 금액충전");
			System.out.println("5. 총 구매정보");
			System.out.println("0. 구매종료");
			System.out.println("번호를 입력하세요");
			int choice = scan.nextInt();
			String correct = "";
			switch (choice) {
			case 1:
				System.out.printf("담으실 제품을 고르세요\n0.상위메뉴 이동\n");
				System.out.printf("1.냉장고\n2.워셔\n3.에어컨\n4.스타일러\n");
				int input_list = scan.nextInt();
				if(input_list == 0) {
					break;
				}
				switch (input_list) {
				
				
				case 1://냉장고담기
					b.product_info(new Refrigerator());
					System.out.printf("선택하신 제품을 담으시겠습니까?\n담으실려면 :Y를 아니면 :N을 입력해주세요\n");
					 correct = scan.next();
					if(correct.equals("Y") || correct.equals("y")) {
						b.product_input_list(new Refrigerator());
					}
					break;
				case 2://워셔
					b.product_info(new Washer());
					System.out.printf("선택하신 제품을 담으시겠습니까?\n담으실려면 :Y를 아니면 :N을 입력해주세요\n");
					 correct = scan.next();
					if(correct.equals("Y") || correct.equals("y")) {
						b.product_input_list(new Washer());
					}
					break;
				case 3://에어컨
					b.product_info(new Conditioner());
					System.out.printf("선택하신 제품을 담으시겠습니까?\n담으실려면 :Y를 아니면 :N을 입력해주세요\n");
					 correct = scan.next();
					if(correct.equals("Y") || correct.equals("y")) {
						System.out.printf("몇개 담으시겠습니까?\n담으실 개수를 입력해주세요\n");
						b.product_input_list(new Conditioner());
					}
					break;
				case 4://스타일러
					b.product_info(new Styler());
					System.out.printf("선택하신 제품을 담으시겠습니까?\n담으실려면 :Y를 아니면 :N을 입력해주세요\n");
					 correct = scan.next();
					if(correct.equals("Y") || correct.equals("y")) {
						System.out.printf("몇개 담으시겠습니까?\n담으실 개수를 입력해주세요\n");
						b.product_input_list(new Styler());
					}
					break;

				}
				break;
			case 2:
				System.out.println("[ 장바구니]");
				System.out.println("[제품]");
				b.product_list();
				System.out.println("구매하실 제품 번호를 입력하세요");
				int buy = scan.nextInt();
				System.out.println("구매할 개수를 입력하세요");
				int buy_thing =scan.nextInt();
				b.product_list_buy(buy,buy_thing);
				break;
			case 3:
				System.out.printf("담으실 제품을 고르세요\n0.상위메뉴 이동\n");
				System.out.printf("1.냉장고\n2.워셔\n3.에어컨\n4.스타일러\n");
				int buy_num = scan.nextInt();
				if(buy_num == 0) {
					break;
				}
				int thing = 0;
				switch (buy_num) {
				case 1:
					System.out.println("구매할 개수를 입력해주세요");
					thing = scan.nextInt();
					b.buy(new Refrigerator(),thing);
					
					break;
				case 2:
					System.out.println("구매할 개수를 입력해주세요");
					thing = scan.nextInt();
					b.buy(new Washer(),thing);
					break;
				case 3:
					System.out.println("구매할 개수를 입력해주세요");
					thing = scan.nextInt();
					b.buy(new Conditioner(),thing);
					break;
				case 4:
					System.out.println("구매할 개수를 입력해주세요");
					thing = scan.nextInt();
					b.buy(new Styler(),thing);
					break;

				}
				break;
			case 4:
				System.out.println("얼마를 충전하시겠습니까?");
				System.out.printf("현재잔액 : %d만원\n",b.money);
				int money = scan.nextInt();
				b.money += money;
				System.out.printf("%d만원 충전되었습니다\n 충전후 잔액: %d만원\n",money,b.money);
				break;
			case 5:
				int total_price = 0;
				System.out.println("[ 총 구매목록 ]");
				for(int i=0; i<b.cart.size(); i++) {
					System.out.printf("%s ",b.cart.get(i).pro_name);
					total_price += b.cart.get(i).pro_pirce;
				}
				System.out.printf("\n총 구매금액 :%d \n",total_price);
				System.out.printf("총 보너스 포인트: %.0f점\n",b.my_bonusPoint);
				System.out.printf("총 구매개수 :%d개\n ",b.cart.size());
				break;
			case 0:
				System.out.println("구매를 종료합니다.");
				break l1;

			default:
				System.out.println("번호를 잘못입력하셨습니다.");
				break;
			}
			
		}
	}//main
	
}
