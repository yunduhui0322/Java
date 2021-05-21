
public class Product {

	static int count;//클래스 변수
	int serialNo;// 인스턴스 변수
	String product_name;//제품명
	int price;//가격
	int bonusPoint;
	
	{
		serialNo = ++count;
	}//인스턴스 초기화 블럭
	Product(){
		}//생성자
	Product(String product_name , int price){
		this.product_name = product_name;
		this.price = price;
		this.bonusPoint = price/100;
	}
}
