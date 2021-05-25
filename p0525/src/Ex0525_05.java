import java.util.Scanner;

public class Ex0525_05 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Student[] s = new Student[10];
		l1:while(true) {
			StudentProgram.mainPirnt();
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				StudentProgram.student_insert(s);
				break;
			case 2:
				StudentProgram.student_print(s);
				break;
			case 3:
				StudentProgram.student_update(s);
				break;
			case 4:
				StudentProgram.sutdent_select(s);
				break;
			case 5:
				StudentProgram.rank_process(s);
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				break l1;

			default:
				System.out.println("번호를 잘못 입력하셨습니다");
				break;
			}
		}
	}//main
}//class
