import java.util.Scanner;

public class StudentProgram {
	static Scanner scan = new Scanner(System.in);
	static public void mainPirnt() {
		System.out.println("[ 학생성적 프로그램 ]");
		System.out.println("1.학생성적 추가");
		System.out.println("2.학생성적 출력");
		System.out.println("3.학생성적 수정");
		System.out.println("4.학생성적 검색");
		System.out.println("5.학생등수 처리");
		System.out.println("0.프로그램 종료");
		System.out.println("원하는 번호를 입력하세요");
	}
	static void topTitle() {
		System.out.printf("번호\t이름\t국어\t영어\t수학\t합계\t평균\t등수\n");
	}
	static void student_insert(Student[]s) {
		String name ="";
		int kor,math,eng = 0;
		for(int i=Student.count; i<s.length; i++) {
			System.out.println("학생이름을 입력하세요(0.상위메뉴 이동)");
			name = scan.next();
			if(name.equals("0")) {
				System.out.println("상위메뉴로 이동합니다");
				break;
			}
			System.out.println("국어점수를 입력하세요");
			kor = scan.nextInt();
			System.out.println("영어점수를 입력하세요");
			math = scan.nextInt();
			System.out.println("수학점수를 입력하세요");
			eng = scan.nextInt();
			s[i] = new Student(name,kor,math,eng);
		}
	}//입력
	static void student_print(Student[]s) {
		topTitle();
		for(int i=0;i<Student.count;i++) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",s[i].getStu_num(),s[i].getName(),s[i].getKor(),s[i].getEng(),s[i].getMath(),s[i].getTotal(),s[i].getAvg(),s[i].getRank());
		}
	}//출력
	
	static void student_update(Student[]s) {
		System.out.println("수정하실 학생이름을 입력하세요");
		String searchName ="";
		int fixNameNo = 0;
		int searchNameNo = 0;
		int fixSubNo = 0;
		searchNameNo = -1;
		searchName=scan.next();
		for(int i=0; i<Student.count; i++) {
			if(s[i].getName().contains(searchName)) {
				System.out.printf("%d. %s\n",(i+1),s[i].getName());
				searchNameNo = 0;
			}
		}
		if(searchNameNo == -1) {
			System.out.println("검색한 이름이 없습니다.");
		}else {
			System.out.println("수정하실 학생번호를 입력하세요");
			fixNameNo = scan.nextInt();
			System.out.println("수정하실 과목번호를 입력하세요");
			System.out.printf("1.국어\n2.영어\n3.수학\n");
			fixSubNo = scan.nextInt();
			switch (fixSubNo) {
			case 1:
				int fixKor = 0;
				System.out.printf("현재국어 점수 %d점\n수정하실 점수를 입력하세요\n",s[fixNameNo-1].getKor());
				fixKor = scan.nextInt();
				s[fixNameNo-1].setKor(fixKor);
				break;
			case 2:
				int fixEng = 0;
				System.out.printf("현재영어 점수 %d점\n수정하실 점수를 입력하세요\n",s[fixNameNo-1].getEng());
				fixKor = scan.nextInt();
				s[fixNameNo-1].setEng(fixEng);
				break;
			case 3:
				int fixMath = 0;
				System.out.printf("현재수학 점수 %d점\n수정하실 점수를 입력하세요\n",s[fixNameNo-1].getMath());
				fixMath = scan.nextInt();
				s[fixNameNo-1].setMath(fixMath);
				break;

			default:
				System.out.println("잘못 입력 하셨습니다");
				break;
			}
			System.out.println("성적수정이 완료되었습니다.");
		}

		
	}//수정
	
	static void sutdent_select(Student[]s) {
		String findName = "";
		int findNameNo = 0;
		System.out.println("검색하실 학생이름을 입력하세요");
		findName = scan.next();
		findNameNo = -1;
		topTitle();
		for(int i=0; i<Student.count; i++) {
			if(s[i].getName().contains(findName)) {
				System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",s[i].getStu_num(),s[i].getName(),s[i].getKor(),s[i].getEng(),s[i].getMath(),s[i].getTotal(),s[i].getAvg(),s[i].getRank());
				findNameNo = 0;
			}
		}
		if(findNameNo ==-1) {
			System.out.println("입력하신 학생이 없습니다.");
		}
	}//검색
	static void rank_process(Student[]s) {
		for(int i=0;i<Student.count;i++) {
			int rankNum = 1;
			for(int j=0; j<Student.count; j++) {
				if(s[i].getTotal()<s[j].getTotal()) {
					rankNum++;
				}
			}
			s[i].setRank(rankNum);
		}
		System.out.println("등수처리가 완료되었습니다.");
	}//등수처리
}
