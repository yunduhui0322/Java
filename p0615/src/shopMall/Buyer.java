package shopMall;

import java.util.ArrayList;

public class Buyer {

	private int money, bonusPoint;

	Buyer() {
		money = 1000;
		bonusPoint = 0;
	}

	ArrayList<Product> buy_arr = new ArrayList<Product>();

	public void mainPirnt() {
		System.out.println("[ 쇼핑몰 프로그램 ]");
		System.out.println("1. 맥북 노트북 구매");
		System.out.println("2. 아이폰 구매");
		System.out.println("3. OLED TV 구매");
		System.out.println("4. 구매목록 보기");
		System.out.println("5. 현금충전");
		System.out.println("구매하실 물품 번호를 입력하세요");
	}

	

	public void buy(Product p, int count) {
		if (money < p.getPrice() * count) {
			System.out.printf("금액이 부족합니다.\n현재 보유금액으로 구매할수있는 총 개수: %d개\n", money / p.getPrice());
			return;
		}
		for (int i = 0; i < count; i++) {
			money -= p.getPrice();
			bonusPoint += p.getBonusPoint();
			buy_arr.add(p);

		}

		System.out.printf("%d개 구매되었습니다.\n현재금액 : %d\n", count, money);

	}

	public void buy_list() {
		int total_price = 0;
		System.out.println("[ 구매목록 ]");
		for (int i = 0; i < buy_arr.size(); i++) {
			System.out.printf("%d. %s\n", (i + 1), buy_arr.get(i).getName());
			total_price += buy_arr.get(i).getPrice();
		}
		System.out.printf("총 구매금액: %d\n총 구매 개수: %d\n", total_price, buy_arr.size());

	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money += money;
		System.out.println("충전후 금액: " + this.money);
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

}
