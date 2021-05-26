package pack02;

public class Product {
	String pro_name;
	int price;
	double bonusPoint;
	Product(){
		
	}
	Product(String pro_name,int price){
		this.pro_name = pro_name;
		this.price = price;
		this.bonusPoint = price*0.1;
	}
}
