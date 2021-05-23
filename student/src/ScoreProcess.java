import java.util.Scanner;
public class ScoreProcess {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Student[] s = new Student[10];
		
		scorePro:while(true) {
			mainPrint();
			int choice = scan.nextInt();
			switch (choice) {
			case 1://성적추가
				scoreInsert(s);
				break;
			case 2://성적출력
				scorePrint(s);
				break;
			case 3://성적수정
				scoreFix(s);
				break;
			case 4://성적검색
				scoreSearch(s);
				break;
			case 5://등수처리
				scoreRank(s);
				break;
			case 0://프로그램종료
				System.out.println("프로그램을 종료합니다");
				break scorePro;

			}//switch -program 
		}//while -scoerPro
	}//main
	
	static void mainPrint() {
		System.out.println("[ 성적처리 프로그램]");
		System.out.println("1. 학생성적 추가");
		System.out.println("2. 학생성적 출력");
		System.out.println("3. 학생성적 수정");
		System.out.println("4. 학생섲거 검색");
		System.out.println("5. 학생등수 처리");
		System.out.println("0. 프로그램 종료 ");
		System.out.println("원하는 번호를 선택하세요");
	}//mainPrint method
	
	static void topTitle() {
		System.out.printf("번호\t이름\t국어\t영어\t수학\t합계\t평균\t등수\n");
	}
	
	static void scoreInsert(Student[] s) {
		for(int i = Student.count; i<s.length; i++) {
			String name = "";
			int kor,eng,math = 0;
			
			System.out.println("학생이름을 입력하세요(0.상위메뉴 이동)");
			name = scan.next();
			if(name.equals("0")) {
				break;
			}
			System.out.println("국어점수를 입력하세요");
			kor = scan.nextInt();
			System.out.println("영어점수를 입력하세요");
			eng = scan.nextInt();
			System.out.println("수학점수를 입력하세요");
			math = scan.nextInt();
			s[i] = new Student(name,kor,eng,math);
		}
	}//scoreInsert method
	
	static void scorePrint(Student[] s) {
		topTitle();
		for(int i=0; i<Student.count; i++) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",s[i].stu_number,s[i].name,s[i].kor,
					s[i].eng,s[i].math,s[i].total,s[i].avg,s[i].rank);
		}
	}//scorePrint method
	
	static void scoreFix(Student[] s) {
		fixPro:while(true) {
			String searchName = "";
			int searchNameNo = 0;
			int fixNameNo = 0;
			int fixSubNo = 0;
			System.out.println("수정할 학생이름을 입력하세요");
			searchName = scan.next();
			searchNameNo = -1;
			for(int i=0; i<Student.count; i++) {
				if(s[i].name.contains(searchName)) {
					System.out.printf("%d. %s\n",i,s[i].name);
					searchNameNo = 0;
				}
			}
			switch (searchNameNo) {
			case -1:
				System.out.println("검색하신 학생이름이 존재하지 않습니다\n 다시입력하세요");
				break;
			case 0:
				System.out.println("\n수정하실 학생번호를 입력하세요");
				fixNameNo = scan.nextInt();
				System.out.println("\n수정하실 과목번호를 입력하세요");
				System.out.printf("1.국어\n2.영어\n3.수학");
				fixSubNo = scan.nextInt();
				switch (fixSubNo) {
				case 1://국어수정
					System.out.printf("현재 국어점수: %d점\n수정할 점수를 입력하세요 ",s[fixNameNo].kor);
					s[fixNameNo].kor = scan.nextInt();
					break;
				case 2://영어수정
					System.out.printf("현재 영어점수: %d점\n수정할 점수를 입력하세요 ",s[fixNameNo].eng);
					s[fixNameNo].eng = scan.nextInt();
					break;
				case 3://수학수정
					System.out.printf("현재 수학점수: %d점\n수정할 점수를 입력하세요 ",s[fixNameNo].math);
					s[fixNameNo].math = scan.nextInt();
					break;
				}//switch fixSubNo
				s[fixNameNo].total = s[fixNameNo].kor + s[fixNameNo].eng + s[fixNameNo].math;
				s[fixNameNo].avg = (double)s[fixNameNo].total/3;
				System.out.println("점수 수정이 완료되었습니다");
				break fixPro;
			}//switch searchNameNo
			
		}//while fixPro
	}//scoreFix method
	static void scoreSearch(Student[] s) {
		searchPro:while(true) {
			String searchName = "";
			int searchNameNo = 0;
			System.out.println("검색할 학생이름을 입력하세요");
			searchName = scan.next();
			searchNameNo = -1;
			for(int i=0; i<Student.count; i++) {
				if(s[i].name.contains(searchName)) {
					searchNameNo = 0;
				}
			}
			switch (searchNameNo) {
			case -1:
				System.out.println("검색하신 이름이 존재하지않습니다.\n다시입력하세요.\n");
				break;
			case -0:
				topTitle();
				for(int i=0; i<Student.count; i++) {
					if(s[i].name.contains(searchName)) {
						System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",s[i].stu_number,s[i].name,s[i].kor,
								s[i].eng,s[i].math,s[i].total,s[i].avg,s[i].rank);

					}
				}
				System.out.println("검색을 완료했습니다.");
				break searchPro;
			}//switch searchNameNo
		}//while searchPro
	}//scoreSearch method
	
	static void scoreRank(Student[]s) {
		for(int i=0; i<Student.count; i++) {
			int rankNum = 1;
			for(int j=0; j<Student.count; j++) {
				if(s[i].total<s[j].total) {
					rankNum++;
				}
			}
			s[i].rank = rankNum;
		}
		System.out.println("등수처리가 완료되었습니다.");
	}//scoreRank method
}//class
