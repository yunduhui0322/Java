package shopMall;

import java.util.Scanner;

public class SMain0615 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Buyer b = new Buyer();
		while(true) {
			b.mainPirnt();
			switch (sc.nextInt()) {
			case 1:
				if (b.getMoney() <= 0) {
					System.out.println("금액이 부족합니다. 충전하세요");
					break;
				}
				System.out.println("구매하실 개수를 입력하세요");
				b.buy(new NoteBook(), sc.nextInt());
				break;
			case 2:
				if (b.getMoney() <= 0) {
					System.out.println("금액이 부족합니다. 충전하세요");
					break;
				}
				System.out.println("구매하실 개수를 입력하세요");
				b.buy(new SmartPhone(), sc.nextInt());
				break;
			case 3:
				if (b.getMoney() <= 0) {
					System.out.println("금액이 부족합니다. 충전하세요");
					break;
				}
				System.out.println("구매하실 개수를 입력하세요");
				b.buy(new Tv(), sc.nextInt());
				break;
			case 4:
				b.buy_list();
				break;
			case 5:
				System.out.printf("현재금액: %d\n충전하실 금액을 입력하세요\n",b.getMoney());
				b.setMoney(sc.nextInt());
				break;

			default:
				break;
			}
		}
	}//maian
}//class
