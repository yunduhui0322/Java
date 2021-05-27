package self;

import java.util.Scanner;

public class Self {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student_Program p = new Student_Program();
		while(true) {
			p.mainPrint();
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				p.student_score_insert();
				break;
			case 2:
				p.student_score_print();
				break;
			case 3:
				p.student_socre_update();
				break;
			case 4:
				p.student_score_select();
				break;
			case 5:
				p.student_score_rank_process();
				break;
			case 6:
				p.student_score_delete();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				break;

			default:
				System.out.println("번호를 잘못입력하셨습니다. 다시입력해주세요.");
				break;
			}
		}
	}//main

}//class
