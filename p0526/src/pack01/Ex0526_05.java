package pack01;

public class Ex0526_05 {

	public static void main(String[] args) {
		//Product
		//p1에 c1을 참조변수 복사
		//c1에 p1을 참조변수 복사
		//c2에 c1을 참조변수 복사
		//p1에 s1을 참조변수 복사
		//s1에 p1을 참조변수 복사
		//s2에 s1을 참조변수 복사
		// p1의 참조변수가 누구것인지 instanceOf연사자를 사용해서 출력을 해보세요
//		Car c1 = null;//c1은 Car의 참조변수
		Product p1 = null;
		FireEngine f1 = new FireEngine();
		FireEngine f2 = null;
		FireEngine f3 = null;
		Ambulance a1 = new Ambulance();
		Ambulance a2 = null;
		Ambulance a3 = null;
		SmartPhone s1 = new SmartPhone();
		SmartPhone s2 = null;
		SmartPhone s3 = null;
		Computer c1 = new Computer();
		Computer c2 = null;
		Computer c3 = null;
		
		p1 = c1;
		c1 = (Computer)p1;
		c2 = c1;
		
		p1 = s1;
		s1 = (SmartPhone)p1;
		s2 = s1;
		
		if(p1 instanceof Computer) {
			System.out.println("Computer의 참조변수");
		}else if(p1 instanceof SmartPhone) {
			System.out.println("SmartPhone의 참조변수");
		}
		
//		c1 = a1;
//		
//		if(c1 instanceof FireEngine) {
//			f3 = (FireEngine)c1;
//			System.out.println("FireEngine 참조변수에 복사했습니다.");
//		}else if(c1 instanceof Ambulance){
//			a3 = (Ambulance)c1;
//			System.out.println("Ambulance 참조변수에 복사했습니다.");
//		}
//		
//		if(c1 instanceof FireEngine) {
//			System.out.println("FireEngine 참조변수 입니다.");
//			
//		}
	}//main
}//class
