package pack01;

public class Ex0526_01 {
	public static void main(String[] args) {
		Tv t = new Tv();
		t.channel = 7;
		CaptionTv ctv = new CaptionTv();
		ctv.text = "라라라~~~";
		
		Tv t2 = new CaptionTv();
		
		
		Tv tt = null;
		CaptionTv cctv = null;
//		tt = cctv;//자손 -> 조상 : 형변환 생략
		cctv = (CaptionTv) tt;// 조상-> 자손 : 형변환 명시(필수)
	
		//객체가 생성된것이 없다면 주소는 왔다리갔다리 가능하다 하지만 객체는 왔다리갔다리 할수있다.

		//t = ctv;//객체가 생성되어있을시 다형성:조상의 참조변수로 자손의 객체를다루는것
				
		// Tv t = new CaptionTv();
		
//		ctv = t; //자손의 참조변수로 조상의객체를 다루는것은 안된다.
	}//main
}//class
