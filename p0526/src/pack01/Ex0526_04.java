package pack01;

public class Ex0526_04 {
	public static void main(String[] args) {
		Product p1 = null;
		Product p2 = new Product();
		Product p3 = null;
		Computer c1 = new Computer();
		Computer c2 = null;
		Computer c3 = null;
		SmartPhone s1 = new SmartPhone();
		SmartPhone s2 = null;
		SmartPhone s3 = null;
		
		//c1 -> p1, p1->c2,c3
		//s1=> p3, p3->s2, s2->p1, p1->s3
		p1 = c1;
		c2 = (Computer)p1;
		
		p3 = s1;
		s2 = (SmartPhone)p3;
		p1 = s1;
		s3 = (SmartPhone)p1;
		s1.call();
		s2.call();
		s3.call();
//		s1.battery = "SamSung";
//		System.out.println(s1.battery+" , "+s2.battery+" , "+s3.battery);
		
		
//		p1 = c1; //다형성 : 조상의 참조변수로 자손의 객체를 다루는것
//		p1 = s1;
//		c1 = (Computer)p1;
//		c1.cpuSpeed();
//		
//		p1 =c1;
//		c2 = (Computer)p1;
//		c2.cpuSpeed();
//		
	}//main
}//class
