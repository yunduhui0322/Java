package pack02;

public class Ex0526_001 {
	public static void main(String[] args) {
		Buyer b1 = new Buyer();
		b1.member_id = "member01";
		b1.name = "윤두희";
		b1.buy(new Tv());
		b1.buy(new Computer());
		b1.buy(new Computer());
		b1.buy(new Computer());

		int sum = 0;
		double bonus = 0;
		String buy_print="";
		for (int i = 0; i < b1.buy_count; i++) {
			System.out.printf("%d번쨰구매제품: %s ,가격: %d\n", (i + 1), b1.cart[i].pro_name, b1.cart[i].price);
			sum += b1.cart[i].price;
			bonus += b1.cart[i].bonusPoint;
			buy_print = buy_print + b1.cart[i].pro_name + " "; 
		}
		System.out.println("구매목록 : "+buy_print);
		System.out.printf("\n총구매금액 : %d", sum);
		System.out.printf("\n총보너스포인트 : %.0f", bonus);
	}// main
}// class
