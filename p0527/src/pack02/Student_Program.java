package pack02;

import java.util.Scanner;

public class Student_Program {
	static Scanner scan = new Scanner(System.in);

	static void mainPrint() {
		System.out.println("[ 학생성적 프로그램 ");
		System.out.println("1. 학생성적추가");
		System.out.println("2. 학생성적출력");
		System.out.println("3. 학생성적수정");
		System.out.println("4. 학생성적검색");
		System.out.println("5. 등수처리");
		System.out.println("0. 프로그램종료");
		System.out.println("원하는 번호를 입력하세요");
	}

	static void student_insert(Student[] s) {
		String name = "";
		int kor = 0;
		int eng = 0;
		int math = 0;

		for (int i = Student.count; i < s.length; i++) {
			System.out.println("이름을 입력하세요 (0.상위메뉴이동)");
			name = scan.next();
			if (name.equals("0")) {
				System.out.println("상위메뉴로 이동합니다");
				break;
			}
			System.out.println("국어점수를 입력하세요");
			kor = scan.nextInt();
			System.out.println("영어점수를 입력하세요");
			eng = scan.nextInt();
			System.out.println("수학점수를 입력하세요");
			math = scan.nextInt();
			s[i] = new Student(name, kor, eng, math);
		}

	}// student_insert method

	static void top_title() {
		System.out.printf("번호\t이름\t국어\t영어\t수학\t합계\t평균\t등수\n");
	}

	static void student_print(Student[] s) {
		top_title();
		for (int i = 0; i < Student.count; i++) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", s[i].getStu_num(), s[i].getName(), s[i].getKor(),
					s[i].getEng(), s[i].getMath(), s[i].getTotal(), s[i].getAvg(), s[i].getRank());
		}
	}// student_print method

	static void student_fix(Student[] s) {
		String searchName = "";
		int searchNameNo = 0;
		int fixNameNo = 0;
		int fixSubNo = 0;
		System.out.println("수정하실 학생이름을 입력하세요");
		searchName = scan.next();
		searchNameNo = -1;
		for (int i = 0; i < Student.count; i++) {
			if (s[i].getName().contains(searchName)) {
				System.out.printf("%d. %s\n", (i + 1), s[i].getName());
				searchNameNo = 0;
			}
		}
		if (searchNameNo == -1) {
			System.out.println("찾으시는 이름이 없습니다.");
			return;
		}
		System.out.println("수정하실 학생번호를 입력하세요");
		fixNameNo = scan.nextInt();
		System.out.println("수정하실 과목의 번호를 입력하세요");
		System.out.printf("1.국어\n2.영어\n3.수학\n");
		fixSubNo = scan.nextInt();
		switch (fixSubNo) {
		case 1:
			System.out.printf("현재 국어점수: %d점\n수정하실 점수를 입력하세요\n", s[fixNameNo - 1].getKor());
			s[fixNameNo - 1].setKor(scan.nextInt());
			break;
		case 2:
			System.out.printf("현재 영어점수: %d점\n수정하실 점수를 입력하세요\n", s[fixNameNo - 1].getEng());
			s[fixNameNo - 1].setEng(scan.nextInt());
			break;
		case 3:
			System.out.printf("현재 수학점수: %d점\n수정하실 점수를 입력하세요\n", s[fixNameNo - 1].getMath());
			s[fixNameNo - 1].setMath(scan.nextInt());
			break;

		}
		System.out.println("성적수정이 완료되었습니다.");
	}// student_fix method

	static void student_search(Student[] s) {
		int findNameNo = 0;
		System.out.println("검색하실 학생이름을 입력하세요");
		String findName = scan.next();
		findNameNo = -1;
		for (int i = 0; i < Student.count; i++) {
			if (s[i].getName().contains(findName)) {
				System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", s[i].getStu_num(), s[i].getName(),
						s[i].getKor(), s[i].getEng(), s[i].getMath(), s[i].getTotal(), s[i].getAvg(), s[i].getRank());
			findNameNo = 0;
			}
		}
		if (findNameNo == -1) {
			System.out.println("검색하신 이름이 없습니다.");
			return;
		}

	}// student_search method

	static void rank_process(Student[] s) {
		for (int i = 0; i < Student.count; i++) {
			int rankNum = 1;
			for (int j = 0; j < Student.count; j++) {
				if (s[i].getTotal() < s[j].getTotal()) {
					rankNum++;
				}
			}
			s[i].setRank(rankNum);
		}
	}// rank_process method
}
