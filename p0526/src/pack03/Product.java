package pack03;

public class Product {
	String pro_name;
	int pro_pirce;
	double pro_bonusPoint;
	
	Product(){
		
	}
	Product(String pro_name, int pro_price){
		this.pro_name = pro_name;
		this.pro_pirce = pro_price;
		this.pro_bonusPoint = pro_price*0.1;
	}
}


