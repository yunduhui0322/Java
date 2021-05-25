
public class LottoBall {
	final int BALL_NUM = 45;;
	int[] ball = new int[BALL_NUM];
	LottoBall(){
		for(int i=0; i<BALL_NUM; i++) {
			ball[i] = i+1;
		}
	}
	
	public void shuffle_ball() {
		for(int i=0; i<1000; i++) {
			int random_num = (int)(Math.random()*BALL_NUM);
			int temp = ball[0];
			ball[0] = ball[random_num];
			ball[random_num] = temp;
		}
		System.out.println("번호가 섞였습니다.");
	}
	
	public void print_6ball() {
		System.out.println("[ 로또번호 ]");
		for(int i=0; i<6; i++) {
			System.out.printf("%d\t",ball[i]);
		}
		System.out.println();
	}
}
