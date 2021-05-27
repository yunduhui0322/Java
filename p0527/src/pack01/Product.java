package pack01;

public class Product {
	static int count;
	private String pro_num;
	private String pro_name;
	private int price;
	private double bonusPoint;
	{
		pro_num = "P" + String.format("%03d", ++count);
		
	}
	Product(){
		
	}
	Product(String pro_name,int price){
		this.pro_name = pro_name;
		this.price = price;
		this.bonusPoint = price*0.1;
				
	}
	public String getPro_num() {
		return pro_num;
	}
	public void setPro_num(String pro_num) {
		this.pro_num = pro_num;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(double bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
}
