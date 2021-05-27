package pack02;
import java.util.Scanner;

public class Ex0527_001 {
	public static void main(String[] args) {
		// 학생성적 프로그램
		Scanner scan = new Scanner(System.in);
		Student[] s = new Student[10];
		
		l1:while(true) {
			Student_Program.mainPrint();
		int choice = scan.nextInt();
		
		switch (choice) {
		case 1:
			Student_Program.student_insert(s);
			break;
		case 2:
			Student_Program.student_print(s);
			break;
		case 3:
			Student_Program.student_fix(s);
			break;
		case 4:
			Student_Program.student_search(s);
			break;
		case 5:
			Student_Program.rank_process(s);
			break;
		case 0:
			System.out.println("프로그램을 종료합니다");
			break l1;

		default:
			break;
		}
				
		
		}
	}
}
