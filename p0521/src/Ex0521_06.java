import java.util.Scanner;

public class Ex0521_06 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Student2[] s = new Student2[10];
		Score_Process score = new Score_Process();

		loop: while (true) {
			score.mainPrint();
			int choice = 0;
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				score.studentInsert(s);
				break;
			case 2:
				score.studentPrint(s);
				break;
			case 3:
				score.studentUpdate(s);
				break;
			case 4:
				score.studentSelect(s);
				break;
			case 5:
				score.rankProcess(s);
				break;
			case 6:// 프로그램 종료

				break loop;
			}

		}
	}// main

}// class
