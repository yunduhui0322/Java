package pack03;

import java.util.ArrayList;

public class Buyer {
	int money = 2000;
	double my_bonusPoint = 0;
	ArrayList<Product> cart = new ArrayList<Product>();
	ArrayList<Product> buy_list = new ArrayList<Product>();

	void buy(Product p, int thing) {
		for(int i=0; i<thing; i++) {
			if (money < p.pro_pirce) {
				System.out.printf("%s가 %d개구매되었습니다.\n", p.pro_name,(i+1));
				System.out.println("금액이 부족합니다. 충전하세요");
				System.out.printf("현재 보유잔액 : %d만원\n", money);
				return;
			}
			money -= p.pro_pirce;
			my_bonusPoint += p.pro_bonusPoint;
			
			cart.add(p);
			
		}
		System.out.printf("%s가 %d개구매되었습니다.\n", p.pro_name,thing);
		System.out.printf("현재 보유잔액 : %d만원\n", money);
	}

	void product_info(Product p) {
		System.out.printf("[선택하신 제품정보]\n이름: %s, 가격: %d, 보너스포인트: %.0f\n", p.pro_name, p.pro_pirce, p.pro_bonusPoint);
	}

	void product_input_list(Product p) {
		buy_list.add(p);
		System.out.printf("%s가 장바구니에 담겼습니다.\n", p.pro_name);
	}// 장바구니에 담기

	void product_list() {
		for (int i = 0; i < buy_list.size(); i++) {
			System.out.printf("%d. %s\t\n", (i + 1), buy_list.get(i).pro_name);
		}
	}

	void product_list_buy(int buy_num,int buy_thing) {
		if(buy_list.isEmpty()) {
			System.out.println("장바구니가 비어있습니다.  채워주세요");
			return;
		}
		for(int i=0; i<buy_thing; i++) {
			if (money < buy_list.get(buy_num-1).pro_pirce) {
				System.out.printf("%s가 %d개구매되었습니다.\n", buy_list.get(buy_num-1).pro_name,(i+1));
				System.out.println("금액이 부족합니다. 충전하세요");
				System.out.printf("현재 보유잔액 : %d만원\n", money);
				return;
			}
			money -= buy_list.get(buy_num - 1).pro_pirce;
			my_bonusPoint += buy_list.get(buy_num - 1).pro_bonusPoint;
			
			cart.add(buy_list.get(buy_num - 1));
			}
			
		System.out.printf("%s가 %d개구매되었습니다.\n", buy_list.get(buy_num-1).pro_name,buy_thing);
		System.out.printf("현재 보유잔액 : %d만원\n",money);
		buy_list.remove(buy_num - 1);
		if(buy_list.size() == 0) {
			System.out.println("장바구니가 비어있습니다.다시  채워주세요");
			return;
		}
	}
}
