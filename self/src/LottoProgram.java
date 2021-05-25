
public class LottoProgram {
	final int LOTTO = 6;
	int input_myBall;
	int count;
	LottoBall b = new LottoBall();
	String[] myBall = new String[LOTTO];
	int[] sameBall = new int[6];

	public void program_MainPrint() {
		System.out.println("[ 로또번호 맞추기 ]");
		System.out.println("1. 로또번호 섞기");
		System.out.println("2. 로또번호 맞추기");
		System.out.println("0. 프로그램 종료");
		System.out.println("원하는 번호를 입력하세요");

	}// mainprint method

	public void lotto_get(String[] myBall, LottoBall b) {
		
		for (int i = 0; i < LOTTO; i++) {
			for(int j=0; j<LOTTO; j++) {
				if (Integer.parseInt(myBall[i]) == b.ball[j]) {
					sameBall[count] = Integer.parseInt(myBall[i]);
					count++;
				}
				
			}
		}

		if (count != 0) {
			System.out.printf("맞은 개수 : %d\n", count);
			for (int i = 0; i < count; i++) {
				System.out.println("[ 맞은 로또번호 ]");
				System.out.printf("%d\t", sameBall[i]);
			}
			System.out.println();
		} else {
			System.out.println("맞은 로또번호는 없습니다.");
		}
	}
}// class
