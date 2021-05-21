import java.util.Scanner;

public class Student {
	static Scanner scan = new Scanner(System.in);

	static int count;
	String stu_num;
	String name;
	int kor;
	int eng;
	int math;
	int total;
	double avg;
	int rank;
	{
		stu_num = "S" + String.format("%03d", ++count);// 학생번호 S001,S002
	}// 초기화 블록

	Student() {
	}

	Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.avg = (double) this.total / 3;
	}// student 생성자

	void fixKor(int kor) {
		this.kor = kor;
		this.total = kor + eng + math;
		this.avg = (double) this.total / 3;
	}// fixKor method

	void fixEng(int eng) {
		this.eng = eng;
		this.total = eng + kor + math;
		this.avg = (double) this.total / 3;
	}// fixEng method

	void fixMath(int math) {
		this.math = math;
		this.total = math + kor + eng;
		this.avg = (double) this.total / 3;
	}// fixMath method


	static void mainPrint() {
		System.out.println("[ 학생성적 처리 프로그램]");
		System.out.println("1. 학생성적 추가");
		System.out.println("2. 학생성적 출력");
		System.out.println("3. 학생성적 수정");
		System.out.println("4. 학생성적 검색");
		System.out.println("5. 학생성적 등수");
		System.out.println("6. 프로그램종료");
	}// mainPrint method

	static void student_insert(Student[] stu) {
		String name = "";
		int kor = 0;
		int eng = 0;
		int math = 0;
		System.out.println("학생성적 추가");
		for (int i = Student.count; i < stu.length; i++) {
			System.out.println("이름을 입력하세요(0.상위메뉴 이동)");
			String proOut = scan.next();
			if (proOut.equals("0")) {
				break;
			}
			name = proOut;
			System.out.println("국어점수를 입력하세요");
			kor = scan.nextInt();
			System.out.println("수학점수를 입력하세요");
			eng = scan.nextInt();
			System.out.println("영어점수를 입력하세요");
			math = scan.nextInt();
			// 10명 학생입력 학생성적 추가만 해보세요.
			stu[i] = new Student(name, kor, eng, math);
		}
	}// input - method

	static void student_print(Student[] stu) {
		Student.top_title();
		for (int i = 0; i < Student.count; i++) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",
					stu[i].stu_num, stu[i].name, stu[i].kor, stu[i].eng,
					stu[i].math, stu[i].total, stu[i].avg, stu[i].rank);
		}
	}// outPut - method

	static void student_update(Student[] stu) {
		loop2: while (true) {

			String searchName = "";
			int searchNameNo = 0;
			System.out.println("[ 학생성적 수정 ]");
			System.out.println("수정할 학생이름을 입력하세요");
			searchName = scan.next();
			if(searchName.equals("0")){
				System.out.println("상위메뉴이동");
				break;
			}
			searchNameNo = -1;
			for (int i = 0; i < Student.count; i++) {
				if (stu[i].name.contains(searchName)) {
					System.out.printf("%d. %s\n", i, stu[i].name);
					searchNameNo = 0;
				}
			}
			switch (searchNameNo) {
			case -1:
				System.out.println("찾으시는 이름이 없습니다");
				System.out.println("다시 입력하세요");
				break;

			case 0:
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
					break loop2;
				case 2:
					System.out.println("수정하실 점수를 입력하세요");
					int inputEng = scan.nextInt();
					stu[fixNameNo].fixEng(inputEng);
					break loop2;
				case 3:
					System.out.println("수정하실 점수를 입력하세요");
					int inputMath = scan.nextInt();
					stu[fixNameNo].fixMath(inputMath);
					break loop2;


				}
				
			}


		}// while loop2

	}// fix - method

	static void top_title() {
		System.out.println("[ 학생성적 출력 ]");
		System.out.printf("번호\t이름\t국어\t영어\t수학\t합계\t평균\t등수\n");
	}// title method

	static void student_select(Student[] stu) {
		String findName = "";
		System.out.println("[ 학생성적 검색 ]");
		System.out.println("학생이름을 입력하세요");
		findName = scan.next();
		top_title();
		for (int i = 0; i < Student.count; i++) {
			if (stu[i].name.contains(findName)) {
				System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", stu[i].stu_num, stu[i].name, stu[i].kor,
						stu[i].eng, stu[i].math, stu[i].total, stu[i].avg, stu[i].rank);
			}
		}
	}// search method

	static void rank_process(Student[] stu) {
		System.out.println("[등수 처리]");
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
