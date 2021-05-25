import java.util.Scanner;

public class Lotto {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		LottoBall b = new LottoBall();
		LottoProgram p = new LottoProgram();
		l1:while(true) {
			p.program_MainPrint();
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				b.shuffle_ball();
				break;
			case 2:
				System.out.println("[ 로또번호 맞추기 ]");
				System.out.println("번호 6개를 ,포함해서 입력하세요 (1~45)");
				String input = scan.next();
				p.myBall = input.split(",");
				p.lotto_get(p.myBall,b);
						
				b.print_6ball();
				break;
			case 0:
				System.out.println("프로그램 종료");
				break l1;
			}
		}
	}
}
