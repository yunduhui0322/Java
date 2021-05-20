import java.util.Scanner;

public class Ex0520_13 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Student[] stu = new Student[10];

		loop1: while (true) {
			Student.mainPrint();
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("학생성적 추가");
				Student.input(stu);

//					System.out.println("이름을 입력하세요");
//					stu[i] = new Student();
//					
//					System.out.println("국어점수를 입력하세요");
//					stu[i].kor = scan.nextInt();
//					
//					System.out.println("영어점수를 입력하세요");
//					stu[i].eng = scan.nextInt();
//					
//					System.out.println("수학점수를 입력하세요");
//					stu[i].math = scan.nextInt();
//					
//					stu[i].total = stu[i].kor + stu[i].eng + stu[i].math;
//					stu[i].avg = (double)stu[i].total/3;

				break;
			case 2:
				System.out.println("[ 학생성적 출력 ]");
				Student.title(stu);
				Student.outPut(stu);
				break;
			case 3:
				System.out.println("[ 학생성적 수정 ]");
				Student.fix(stu);
				break;
			case 4:
				System.out.println("[ 학생성적 검색 ]");
				Student.search(stu);
				break;
			case 5:
				System.out.println("[등수 처리]");
				Student.rank(stu);
				break;
			case 6:
				break loop1;

			default:
				break;
			}// switch
		} // while
	}// main


	

	



	



}// class
