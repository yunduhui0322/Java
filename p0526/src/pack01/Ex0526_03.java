package pack01;

public class Ex0526_03 {
	public static void main(String[] args) {
		Car c = null;
		FireEngine f1 = new FireEngine();
		FireEngine f2 = null;
		c= f1;//f1 객체선언 - 저장 공간이 만들어져 있음.
//		c.water(); f1에서 c변경되면서 명령어는 Car있는것만 사용됨.
		f1.water();
		f2 = (FireEngine)c;//f2 = f1;와같은것 
		f2.water();
	}//main
}//class
