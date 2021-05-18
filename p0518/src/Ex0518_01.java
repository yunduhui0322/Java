
public class Ex0518_01 {
	public static void main(String[] args) {
		
		Time[] t = new Time[3] ;//객체배열 선언 찹조변수의 주솟값 3개가 만들어진다.데이터공간은 X
		for(int i=0; i<t.length; i++) {
			t[i] = new Time();// 객체선언
			t[i].hour = i+1;
			t[i].minute = i+1;
			t[i].second = i+1;
					
		}
		
		for(int i=0; i<t.length; i++) {
			System.out.printf("%d시%d분%d초\n",t[i].hour,t[i].minute,t[i].minute);
		}
		
		
		t[0] = new Time();//저장할수 있는공간이 만들어진다.
		t[0].hour = 1;
		t[0].minute = 1;
		t[0].second = 1;
		
		
		Time tt = new Time();
		
		
			
//		Time t = new Time(); //객체생성
//		t.hour = 1;
//		t.minute = 1;
//		t.second = 1;
//		
//		System.out.printf("%d시%d분%d초",t.hour,t.minute,t.second);
	}//main
}//class
