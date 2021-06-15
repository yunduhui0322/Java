package shopMall;

public class Product {

	private String name;
	private int price,bonusPoint;
	
	Product(){
		
	}
	Product(String name, int price){
		this.name = name;
		this.price = price;
		this.bonusPoint = price/10;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	
	
}
