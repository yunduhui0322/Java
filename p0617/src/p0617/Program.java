package p0617;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ScoreProcess s = new ScoreProcess();
		li:while(true) {
			s.mainPirnt();
			switch (sc.nextInt()) {
			case 1:
				s.socreInsert();
				break;
			case 2:
				s.scorePrint();
				break;
			case 3:
				s.scoreUpdate();
				break;
			case 4:
				s.searchStudent();
				break;
			case 5:
				s.rankProcess();
				break;
			case 6:
				s.load_file();
				break;
			case 7:
				s.save_file();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				break li;

			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}//main
}//class
