
public class Ex0521_01 {
	public static void main(String[] args) {
		//기본생성자를 사용하여 객체 10개를 생성하시오
		Car[] c = new Car[9];
		c[0] = new Car();
		c[1] = new Car("pink","auto",5);
		c[2] = new Car("silver","auto",5);
		c[3] = new Car();
		c[4] = new Car("black","auto",4);
		c[5] = new Car();
		c[6] = new Car();
		c[7] = new Car("green","auto",5);
		c[8] = new Car();
		
//		Car[] c = new Car[3];
//		c[0] = new Car();
//		c[0].color = "white";
//		c[0].gearType = "auto";
//		c[0].door = 4;
//		c[1] = new Car();
//		c[1].color = "pink";
//		c[1].gearType = "auto";
//		c[1].door = 5;
//		c[2] = new Car();
//		c[2].color = "silver";
//		c[2].gearType = "auto";
//		c[2].door = 4;
		
	}//main
}//class
