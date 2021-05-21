import java.util.Scanner;

public class Ex0521_02 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Student[] stu = new Student[10];
		loop1: while (true) {
			Student.mainPrint();
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				Student.student_insert(stu);
				break;
			case 2:
				Student.student_print(stu);
				break;
			case 3:
				Student.student_update(stu);
				break;
			case 4:
				Student.student_select(stu);
				break;
			case 5:
				Student.rank_process(stu);
				break;
			case 6:
				break loop1;

			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}// switch
		} // while
	
	}// main


}// class