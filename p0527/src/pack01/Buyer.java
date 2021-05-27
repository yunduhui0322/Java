package pack01;

import java.util.ArrayList;

public class Buyer {

	
	private String member_id;
	private	String member_pw;
	private	String member_name;
	private	int my_money = 2000;
	private double my_bonusPoint = 0;
	
//	Product[] cart = new Product[10];//구매목록 저장
	ArrayList list = new ArrayList();
	void buy(Product p) {
		if(this.my_money<p.getPrice()) {
			System.out.println("잔액이 부족합니다.돈을 충전하세요");
			return;
		}
				
		this.my_money -= p.getPrice();
		this.my_bonusPoint += p.getBonusPoint();
		list.add(p);
//		cart[count++] = p;
		System.out.printf("%s 제품이 구매되었습니다\n현재금액:%d만원\n현재 보너스 포인트:%.0f\n",p.getPro_name(),my_money,my_bonusPoint);
		
	}
	
	void buy_cart() {
		if(list.isEmpty()) {
			System.out.println("구매하신 물품이 없습니다.");
		}else {
			System.out.println("[ 구매목록 ]");
			int total_price = 0;
			for(int i=0; i<list.size(); i++) {
				Product p = (Product)list.get(i);
				System.out.printf("제품번호:%s 구매제품명:%s\n",p.getPro_num(),p.getPro_name());
				total_price += p.getPrice();
			}
			System.out.println();
			System.out.printf("총 구매개수 : %d개\n",list.size());
			System.out.printf("총 구매금액: %d만원\n",total_price);
			
			
		}
//		int total_price = 0;
//		for(int i=0; i<count; i++) {
//			System.out.printf("제품번호%s 제품명[%s]\n",cart[i].getPro_num(),cart[i].getPro_name());
//			total_price += list.
//		}
//		System.out.printf("총 구매개수 : %d개\n",count);
//		System.out.printf("총 구매금액: %d만원\n",total_price);
//		
	}
	
	void delete_cart() {
		
	}
	
	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public int getMy_money() {
		return my_money;
	}

	public void setMy_money(int my_money) {
		this.my_money += my_money;
		System.out.printf("%d만원이 충전되었습니다",my_money);
		System.out.printf("충전후 금액 :%d만원\n",this.my_money);
	}

	public double getMy_bonusPoint() {
		return my_bonusPoint;
	}

	public void setMy_bonusPoint(int my_bonusPoint) {
		this.my_bonusPoint = my_bonusPoint;
	}


}
