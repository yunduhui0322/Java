
public class LottoBall {
	static int[] ball = new int[45];
	LottoBall() {
		for(int i=0; i<ball.length ; i++) {
			ball[i] = i+1;
		}
		
		for(int i=0; i<200; i++) {
			int temp = 0;
			int rno = (int)(Math.random()*45);
			int rno2 = (int)(Math.random()*45);
			temp = ball[rno];
			ball[rno] = ball[rno2];
			ball[rno2] =temp;
		}
	}//생성자
//	static {
		
//	}//static
	
}
