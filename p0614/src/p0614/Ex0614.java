package p0614;

import java.util.Scanner;

public class Ex0614 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentProcess s = new StudentProcess();
		li1:while(true) {
			s.main_print();
			switch (sc.nextInt()) {
			case 1:
				s.insert_score();
				break;
			case 2:
				s.score_print();
				break;
			case 3:
				s.update_score();
				break;
			case 4:
				s.search_student();
				break;
			case 5:
				s.rank_process();
				break;

			default:
				System.out.println("잘못 입력하셨습니다");
				break li1;
			}
		}
	}//main
}//class
