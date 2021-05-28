package pack01;

import java.util.ArrayList;
import java.util.Scanner;

public class Student_Program {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Student> arr_stu = new ArrayList<Student>();
		Score_Process s = new Score_Process();
		loop: while (true) {

			s.mainPrint();
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				s.student_score_insert(arr_stu);
				break;
			case 2:
				s.student_score_print(arr_stu);
				break;
			case 3:
				s.student_score_update(arr_stu);
				break;
			case 4:
				s.student_score_select(arr_stu);
				break;
			case 5:
				s.score_rank_process(arr_stu);
				break;
			case 6:
				s.student_score_delete(arr_stu);
				break;
			case 0:

				break loop;

			}
		} // while
	}// main
}// class
