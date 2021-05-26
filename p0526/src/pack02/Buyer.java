package pack02;

public class Buyer {
	static int count;
	String member_id;
	String member_pw;
	String name;
	int money = 1000;// 1000만원
	double bonusPoint = 0;
//	{
//		member_num = "B" + String.format("%03d", ++count);
//	}

//	Buyer(){
//		
//	}
//	Buyer(String member_id,String member_pw){
//		
//	}
	int buy_count = 0;
	Product[] cart = new Product[10];

	void buy(Product p/*,Buyer b*/) {
		if (money < p.price) {
			System.out.println("잔액이 부족합니다. 물품을 구매할 수 없습니다 .충전하세요");
			return;//메소드 return 만날씨 종료
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		cart[buy_count++] = p;
		System.out.printf("%s가 구매되었습니다.\n", p.pro_name);
//		System.out.printf("남은돈: %d\n보너스 포인트: %.0f\n", b.money, b.bonusPoint);
	}
//	void buy(Computer c,Buyer b) {
//		money -= c.price;
//		bonusPoint += c.bonusPoint;
//		System.out.printf("%s가 구매되었습니다.\n",c.pro_name);
//		System.out.printf("남은돈: %d\n보너스 포인트: %.0f\n",b.money,b.bonusPoint);
//	}
//	
//	void buy(Audio a, Buyer b) {
//		money -= a.price;
//		bonusPoint += a.bonusPoint;
//		System.out.printf("%s가 구매되었습니다.\n",a.pro_name);
//		System.out.printf("남은돈: %d\n보너스 포인트: %.0f\n",b.money,b.bonusPoint);
//		
//	}
}
