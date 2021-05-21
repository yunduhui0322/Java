import java.util.Scanner;

public class Ex0521_06 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Student2[] s = new Student2[10];

		loop: while (true) {
			mainPrint();
			int choice = 0;
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				studentInsert(s);
				break;
			case 2:
				studentPrint(s);
				break;
			case 3:
				studentUpdate(s);
				break;
			case 4:
				studentSelect(s);
				break;
			case 5:
				rankProcess(s);
				break;
			case 6:// 프로그램 종료

				break loop;
			}

		}
	}// main

	static void mainPrint() {
		System.out.println("[ 성적처리 프로그램 ]");
		System.out.println("1.학생성적 추가");
		System.out.println("2.학생성적 출력");
		System.out.println("3.학생성적 수정");
		System.out.println("4.학생성적 검색");
		System.out.println("5.학생성적 등수");
		System.out.println("6.프로그램 종료");
	}// mainPrint method

	static void studentInsert(Student2[] s) {
		String name = "";
		int kor = 0;
		int math = 0;
		int eng = 0;
		System.out.println("[ 학생성적 추가 ]");
		for (int i = Student2.count; i < s.length; i++) {
			System.out.println("이름을 입력하세요(0.상위메뉴 이동)");
			name = scan.next();
			if (name.equals("0")) {
				System.out.println("상위메뉴로 이동합니다.");
				break;
			}
			System.out.println("국어점수를 입력하세요");
			kor = scan.nextInt();
			System.out.println("영어점수를 입력하세요");
			eng = scan.nextInt();
			System.out.println("수학점수를 입력하세요");
			math = scan.nextInt();

			s[i] = new Student2(name, kor, eng, math);
			System.out.printf("%d번째 학생이 등록되었습니다\n", (i + 1));
		}
	}// studentInsert method

	static void studentPrint(Student2[] s) {
		topTitle();
		for (int i = 0; i < Student2.count; i++) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", s[i].stu_number, s[i].name, s[i].kor, s[i].eng,
					s[i].math, s[i].total, s[i].avg, s[i].rank);
		}
	}// studentPrint

	static void topTitle() {
		System.out.printf("번호\t이름\t국어\t영어\t수학\t합계\t평균\t등수\n");
	}

	static void studentUpdate(Student2[] s) {
		loop2: while (true) {
			String searchName = "";
			int searchNameNo = 0;
			int fixNameNo = 0;
			int fixSubNo = 0;
			searchNameNo = -1;

			System.out.println("[ 학생성적 수정 ]");
			System.out.println("수정할 학생이름을 검색하세요");
			searchName = scan.next();
			for (int i = 0; i < Student2.count; i++) {
				if (s[i].name.contains(searchName)) {
					System.out.printf("%d. %s\n", i, s[i].name);
					searchNameNo = 0;
				}
			}
			switch (searchNameNo) {
			case -1:
				System.out.printf("입력하신 학생이름이 없습니다.\n 다시입력하세요.\n");
				break;
			case 0:
				System.out.println("수정하실 학생 번호를 입력하세요");
				fixNameNo = scan.nextInt();
				System.out.printf("1.국어\n2.영어\n3.수학\n");
				System.out.println("수정하실 과목번호를 입력하세요");
				fixSubNo = scan.nextInt();
				switch (fixSubNo) {
				case 1:
					System.out.printf("현재 국어점수 :%d점\n수정하실 국어점수를 입력하세요\n", s[fixNameNo].kor);
					s[fixNameNo].kor = scan.nextInt();
					break;
				case 2:
					System.out.printf("현재 영어점수 :%d점\n수정하실 영어점수를 입력하세요\n", s[fixNameNo].eng);
					s[fixNameNo].eng = scan.nextInt();
					break;
				case 3:
					System.out.printf("현재 수학점수 :%d점\n수정하실 수학점수를 입력하세요\n", s[fixNameNo].math);
					s[fixNameNo].math = scan.nextInt();
					break;

				}
				s[fixNameNo].total = s[fixNameNo].kor + s[fixNameNo].eng + s[fixNameNo].math;
				s[fixNameNo].avg = (double) s[fixNameNo].total / 3;
				System.out.println("점수수정이 완료되었습니다.");
				break loop2;
			}// switch searchNameNo
		} // while loop2
	}// studentUpdate method

	static void studentSelect(Student2[] s) {
			String findName = "";
			int findNameNo = 0;
			findNameNo = -1;
			System.out.println("[ 학생성적 검색 ]");
			System.out.println("찾으실 학생의 이름을 입력하세요");
			findName = scan.next();
			topTitle();
			for (int i = 0; i < Student2.count; i++) {
				if (s[i].name.contains(findName)) {
					System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", s[i].stu_number, s[i].name, s[i].kor,
							s[i].eng, s[i].math, s[i].total, s[i].avg, s[i].rank);
					findNameNo = 0;
				}
			}
			if(findNameNo == -1) {
				System.out.println("입력하신 학생이름이 없습니다.");
			}
	}// studentSelect method
	static void rankProcess(Student2[] s){
		System.out.println("[ 등수 처리 ]");
		for(int i=0; i<Student2.count; i++) {
			int rankNum = 1;
			for(int j=0; j<Student2.count; j++) {
				if(s[i].total<s[j].total) {
					rankNum++;
				}
			}
			s[i].rank = rankNum;
		}
	}//rankProcess method
}// class
