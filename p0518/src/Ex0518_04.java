import java.util.Scanner;

public class Ex0518_04 {
static	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {

		Student2[] s = new Student2[10];
		// 객체배열 주소선언 - 참조변수주소만 생성됨.
		loop1: while (true) {
			//메인화면 출력 메소드 호출
			mainPrint(); 
			int choice = scan.nextInt();
			switch (choice) {

			case 1:// 학생성적추가-->> 매개변수 s보냄
				stuInput(s);
				break;
			case 2:// 학생성적출력
				stuOutput(s);
				break;
			case 3:// 학생성적수정
				
				System.out.println("수정할 학생이름을 입력하세요");
				String searchName = scan.next();
				int searchNameNo = 0;
				searchNameNo = -1;
				for (int i = 0; i < Student2.count; i++) {
					if (s[i].name.contains(searchName)) {
						System.out.printf("%d. %s\n", i, s[i].name);
						searchNameNo = 0;
					}
				}
				if (searchNameNo == -1) {
					System.out.println("검색하신 이름이 없습니다");
					break;
				}
				System.out.println("수정할 학생 번호를 입력하세요");
				int fixNameNo = scan.nextInt();
				System.out.println("수정할 과목의 번호를 선택하세요");
				System.out.println("1.국어 2.영어 3.수학");
				int fixSubNo = scan.nextInt();
				if (fixSubNo == 1) {//스위치문 가능
					System.out.printf("현재 국어점수 :%d\n ", s[fixNameNo].kor);
					System.out.println("수정할 점수를 입력하세요");
					s[fixNameNo].kor = scan.nextInt();
					s[fixNameNo].total = s[fixNameNo].kor + s[fixNameNo].eng + s[fixNameNo].math;
					s[fixNameNo].avg = (double) s[fixNameNo].total / 3;
				} else if (fixSubNo == 2) {
					System.out.printf("현재 영어점수 : %d\n", s[fixNameNo].eng);
					System.out.println("수정할 점수를 입력하세요");
					s[fixNameNo].eng = scan.nextInt();
					s[fixNameNo].total = s[fixNameNo].kor + s[fixNameNo].eng + s[fixNameNo].math;
					s[fixNameNo].avg = (double) s[fixNameNo].total / 3;
				} else if (fixSubNo == 3) {
					System.out.printf("현재 수학점수 : %d\n", s[fixNameNo].math);
					System.out.println("수정할 점수를 입력하세요");
					s[fixNameNo].math = scan.nextInt();
					s[fixNameNo].total = s[fixNameNo].kor + s[fixNameNo].eng + s[fixNameNo].math;
					s[fixNameNo].avg = (double) s[fixNameNo].total / 3;
				} else {
					System.out.println("잘못 입력하셨습니다");
					break;
				}
				System.out.println("점수수정이 완료되었습니다.");

				break;
			case 4:// 학생성적 검색

				System.out.println("검색할 학생이름을 입력하세요");
				String findName = scan.next();
				int findNameNo = 0;
				findNameNo = -1;
				System.out.printf("번호\t이름\t국어\t영어\t수학\t합계\t평균\t등수\n");
				for (int i = 0; i < Student2.count; i++) {
					if (s[i].name.contains(findName)) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", s[i].stu_number, s[i].name, s[i].kor,
								s[i].eng, s[i].math, s[i].total, s[i].avg, s[i].rank);
						findNameNo = 0;
					}
				}
				if (findNameNo == -1) {
					System.out.println("검색하신 이름이 없습니다");
					break;
				}
				break;
			case 5:
				for (int i = 0; i < Student2.count; i++) {
					int rankNum = 1;
					for (int j = 0; j < Student2.count; j++) {
						if (s[i].total < s[j].total) {
							rankNum++;
						}
					}
					s[i].rank = rankNum;
				}
				System.out.println("등수처리가 완료되었습니다.");
				break;
			case 0:
				break loop1;
			default:
				break;
			}// switch

		} // while

	}// main
	
	
	//main출력화면 메소드
	static void mainPrint() {
		System.out.println(" [학생성적 프로그램] ");
		System.out.println("1.학생성적 추가");
		System.out.println("2.학생성적 출력");
		System.out.println("3.학생성적 수정");
		System.out.println("4.학생성적 검색");
		System.out.println("5.등수처리");
		System.out.println("0.프로그램 종료");
		System.out.println("------------------------");
		System.out.println("원하는 번호를 입력하세요.");

	}
	
	// 1.학생성적 입력 메소드
	static void stuInput(Student2[] s) {
		for (int i = Student2.count; i < s.length; i++) {
			// 번호는 자동으로 입력됨
			System.out.println("이름을 입력하세요(0.상위메뉴 이동)");
			String check = scan.next();
			if (check.equals("0")) {
				break;
			}
			s[i] = new Student2();// 객체생성
			s[i].name = check;
			System.out.println("국어점수를 입력하세요");
			s[i].kor = scan.nextInt();
			System.out.println("영어점수를 입력하세요");
			s[i].eng = scan.nextInt();
			System.out.println("수학점수를 입력하세요");
			s[i].math = scan.nextInt();

			s[i].total = s[i].kor + s[i].eng + s[i].math;
			s[i].avg = (double) s[i].total / 3;
		}

	}//stuInput
	
	//2. 학생성적 출력 메소드
	static void stuOutput(Student2[] s) {
		System.out.printf("번호\t이름\t국어\t영어\t수학\t합계\t평균\t등수\n");
		for (int i = 0; i < Student2.count; i++) {
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", s[i].stu_number, s[i].name, s[i].kor,
					s[i].eng, s[i].math, s[i].total, s[i].avg, s[i].rank);
		}
	}//stuOutput
	
	

}// class
