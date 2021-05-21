
public class Ex0521_04 {
	
	public static void main(String[] args) {
		Product p1 = new Product();
		p1.product_name = "OLED TV";
		p1.price = 700;
		p1.bonusPoint =p1.price/100;
		Product p2 = new Product("냉장고",500);//냉장고 500 5만원 캐쉬백
		Product p3 = new Product("세탁기",200); //세탁기 200 2
		
		System.out.printf("번호 : %d , 제품명 : %s, 가격 :%d , 보너스 포인트 : %d \n"
				,p1.serialNo,p1.product_name,p1.price,p1.bonusPoint);
		System.out.printf("번호 : %d , 제품명 : %s, 가격 :%d , 보너스 포인트 : %d \n"
				,p2.serialNo,p2.product_name,p2.price,p2.bonusPoint);
		System.out.printf("번호 : %d , 제품명 : %s, 가격 :%d , 보너스 포인트 : %d \n"
				,p3.serialNo,p3.product_name,p3.price,p3.bonusPoint);
		
		System.out.println("전체count :" + Product.count +"개");
	}//main
}//class