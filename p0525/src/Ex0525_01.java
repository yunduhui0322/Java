import java.util.Scanner;
public class Ex0525_01 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Deck d = new Deck();
		
		//무한 루프
		l1:while(true) {
			d.menu_Print();
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("카드 번호를 입력하세요(1~52)");
				int num = scan.nextInt();
				d.print_1Card(num-1);
				break;
			case 2:
				d.print_5Card();
				break;
			case 3:
				d.print_52Card();
				break;
			case 4:
				d.shuffle();
				System.out.println("카드를 섞었습니다.");
				break;
			case 5://카드 7장을 내것과 컴퓨터것을 출력시키는 메소드를 작성해보세요
				 	//MYCARD : SPADE,1 HEART 9
					//컴퓨터 CARD : SPADE,J
				d.output_7card(); 
				break;
			case 6:
				break;
			
			case 0:
				System.out.println("프로그램을 종료합니다.");
				break l1;

			default:
				System.out.println("잘못입력했습니다.");
				break;
			}
		}
	}//main
}//class
