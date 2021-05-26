package pack03;

public class Buyer {
	int money = 2000;
	double my_bonusPoint = 0;
	int buy_count = 0;
	int buy_list_count = 0;
	Product[] cart = new Product[10];
	Product[] buyList = new Product[10];
	void buy(Product p) {
		if(money<p.pro_pirce) {
			System.out.println("금액이 부족합니다. 충전하세요");
			System.out.printf("현재 보유잔액 : %d만원\n",money);
			return;
		}
		if(buy_count >9) {
			System.out.println("제품을 11개이상 구매하실 수 없습니다\n프로그램을 종료해주세요\n");
			return;
		}
		money -= p.pro_pirce;
		my_bonusPoint += p.pro_bonusPoint;
		
		cart[buy_count++] = p;
		System.out.printf("%s가 구매되었습니다.\n가격: %d만원\n현재 구매 개수: %d개\n",p.pro_name,p.pro_pirce,buy_count);
		System.out.printf("현재 보유잔액 : %d만원\n",money);
	}
	
	void product_info(Product p) {
		System.out.printf("[선택하신 제품정보]\n이름: %s, 가격: %d, 보너스포인트: %.0f\n",p.pro_name,p.pro_pirce,p.pro_bonusPoint);
	}
	void product_input_list(Product p,int k) {
		
		int buy_number = k;
		for(int i=0; i<buy_number; i++) {
			buyList[buy_list_count++] = p;
			if(buy_list_count >9) {
				System.out.println("장바구니에 제품 11개이상 담으실수 없습니다.\n");
				return;
			}	
		}
		System.out.printf("%s가 장바구니 %d개 담겼습니다.\n현재 장바구니에 제품개수 %d개(장바구니에 담을 수 있는 제품 개수 %d개)\n",p.pro_name,k,buy_list_count,10-buy_list_count);
	}
}
