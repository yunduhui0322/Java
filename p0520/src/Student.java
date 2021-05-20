import java.util.Scanner;

public class Student {
	static Scanner scan = new Scanner(System.in);

	static int count;
	int stu_num = ++count;
	String name;
	int kor;
	int eng;
	int math;
	int total;
	double avg;
	int rank;

	Student() {
	}

	Student(String n, int k, int e, int m) {
		name = n;
		kor = k;
		eng = e;
		math = m;
		total = k + e + m;
		avg = (double) total / 3;
	}// student 생성자

	void fixKor(int k) {
		kor = k;
		total = k + eng + math;
		avg = (double) total / 3;
	}// fixKor method

	void fixEng(int e) {
		eng = e;
		total = e + kor + math;
		avg = (double) total / 3;
	}// fixEng method

	void fixMath(int m) {
		math = m;
		total = m + kor + eng;
		avg = (double) total / 3;
	}// fixMath method

	static void mainPrint() {
		System.out.println("[ 학생성적 처리 프로그램]");
		System.out.println("1. 학생성적 추가");
		System.out.println("2. 학생성적 출력");
		System.out.println("3. 학생성적 수정");
		System.out.println("4. 학생성적 검색");
		System.out.println("5. 학생성적 등수");
		System.out.println("6  .프로그램종료");
	}// mainPrint method

	static void input(Student[] stu) {
		for (int i = Student.count; i < stu.length; i++) {
			System.out.println("이름을 입력하세요(0.상위메뉴 이동)");
			String proOut = scan.next();
			if (proOut.equals("0")) {
				break;
			}
			String name = proOut;
			System.out.println("국어점수를 입력하세요");
			int kor = scan.nextInt();
			System.out.println("수학점수를 입력하세요");
			int eng = scan.nextInt();
			System.out.println("영어점수를 입력하세요");
			int math = scan.nextInt();
			// 10명 학생입력 학생성적 추가만 해보세요.
			stu[i] = new Student(name, kor, eng, math);
		}
	}// input - method

	static void outPut(Student[] stu) {

		for (int i = 0; i < Student.count; i++) {
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", stu[i].stu_num, stu[i].name, stu[i].kor, stu[i].eng,
					stu[i].math, stu[i].total, stu[i].avg, stu[i].rank);
		}
	}// outPut - method

	static void fix(Student[] stu) {

		System.out.println("수정할 학생이름을 입력하세요");
		String searchName = scan.next();
		int searchNameNo = -1;
		for (int i = 0; i < Student.count; i++) {
			if (stu[i].name.contains(searchName)) {
				System.out.printf("%d. %s\n", i, stu[i].name);
				searchNameNo = 0;
			}
		}
		if (searchNameNo == -1) {
			System.out.println("입려하신 이름이 없습니다.");

		}
		System.out.println("수정하실 학생번호를 고르세요");
		int fixNameNo = scan.nextInt();
		System.out.println("수정하실 과목번호를 고르세요");
		System.out.println("1.국어 2.영어 3.수학");
		int fixSubNo = scan.nextInt();
		switch (fixSubNo) {
		case 1:
			System.out.println("수정하실 점수를 입력하세요");
			int inputKor = scan.nextInt();
			stu[fixNameNo].fixKor(inputKor);
			break;
		case 2:
			System.out.println("수정하실 점수를 입력하세요");
			int inputEng = scan.nextInt();
			stu[fixNameNo].fixEng(inputEng);
			break;
		case 3:
			System.out.println("수정하실 점수를 입력하세요");
			int inputMath = scan.nextInt();
			stu[fixNameNo].fixMath(inputMath);
			break;

		default:
			break;
		}
	}// fix - method

	static void title(Student[] stu) {
		System.out.printf("번호\t이름\t국어\t영어\t수학\t합계\t평균\t등수\n");
	}// title method

	static void search(Student[] stu) {
		System.out.println("학생이름을 입력하세요");
		String findName = scan.next();
		title(stu);
		for (int i = 0; i < Student.count; i++) {
			if (stu[i].name.contains(findName)) {
				System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", stu[i].stu_num, stu[i].name, stu[i].kor,
						stu[i].eng, stu[i].math, stu[i].total, stu[i].avg, stu[i].rank);
			}
		}
	}// search method

	static void rank(Student[] stu) {
		for (int i = 0; i < Student.count; i++) {
			int rankNum = 1;
			for (int j = 0; j < Student.count; j++) {
				if (stu[i].total < stu[j].total) {
					rankNum++;
				}
			}
			stu[i].rank = rankNum;
		}
	}// rank method
}// class
