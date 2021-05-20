
public class Ex0520_12 {

	public static void main(String[] args) {
		Car[] c = new Car[5];
//		c.color = "흰색";
//		c.gearType = "자동기어";
//		c.door = 4;
		
		
		//총 4대를 더 생산
		// 파랑, 자동기어,5/ 검정, 수동기어 ,4 / 빨강 , 자동기어 , 5/ 은색 , 수동기어  , 4
		
		c[0] = new Car("파랑","자동기어",5);
		c[1] = new Car("파랑","자동기어",5);
		c[2] = new Car("검정","수동기어",4);
		c[3] = new Car("빨강","자동기어",5);
		c[4] = new Car("은색","수동기어",4);
		
		
//		Car a = new Car();
//		a.color = "파랑";
//		a.gearType = "자동기어";
//		a.door = 5;
//		Car b = new Car();
//		b.color = "검정";
//		b.gearType = "수동기어";
//		b.door = 4;
//		Car d = new Car();
//		d.color = "빨강";
//		d.gearType = "자동기어";
//		d.door = 5;
//		Car e = new Car();
//		e.color = "은색";
//		e.gearType = "수동기어";
//		e.door = 4;
	}//main
}//class
