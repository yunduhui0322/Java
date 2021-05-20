import java.util.Scanner;;

public class Practice {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student[] stuInfo = new Student[10];
		loop1: while (true) {
			System.out.println("[ 성적처리 프로그램 ]");
			System.out.println("1.학생성적 추가");
			System.out.println("2.학생성적 출력");
			System.out.println("3.학생성적 수정");
			System.out.println("4.학생성적 검색");
			System.out.println("5.학생성적 등수처리");
			System.out.println("6.프로그램 종료");

			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				String proOut = "";
				System.out.println("[ 학생성적 추가]");
				for (int i = Student.count; i < stuInfo.length; i++) {
					System.out.printf("%d 번째 학생이름을 입력하세요(0.상위메뉴 이동)\n", i + 1);
					proOut = scan.next();
					if (proOut.equals("0")) {
						System.out.println("상위메뉴로 이동합니다");
						break;
					}

					stuInfo[i] = new Student();
					stuInfo[i].name = proOut;

					System.out.println("국어점수를 입력하세요");
					stuInfo[i].kor = scan.nextInt();
					System.out.println("영어점수를 입력하세요");
					stuInfo[i].eng = scan.nextInt();
					System.out.println("수학점수를 입력하세요");
					stuInfo[i].math = scan.nextInt();

					stuInfo[i].total = stuInfo[i].kor + stuInfo[i].eng + stuInfo[i].math;
					stuInfo[i].avg = (double) stuInfo[i].total / 3;
				}
				break;
			case 2:
				System.out.println("[ 학생성적 출력]");
				System.out.printf("번호\t이름\t국어\t영어\t수학\t합계\t평균\t등수\n");
				for (int i = 0; i < Student.count; i++) {
					System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", stuInfo[i].stu_num, stuInfo[i].name,
							stuInfo[i].kor, stuInfo[i].eng, stuInfo[i].math, stuInfo[i].total, stuInfo[i].avg,
							stuInfo[i].rank);
				}
				break;
			case 3:
				System.out.println("[ 학생성적 수정]");
				System.out.println("수정하실 학생이름을 입력하세요");
				String searchName = scan.next();
				int searchNameNo = -1;
				for (int i = 0; i < Student.count; i++) {
					if (stuInfo[i].name.contains(searchName)) {
						System.out.printf("%d. %s\n", i, stuInfo[i].name);
						searchNameNo = 0;
					}
				}

				if (searchNameNo == -1) {
					System.out.println("입력하신 학생이름이 존재하지 않습니다");
					break;
				}
				System.out.println("수정하실 학생 번호를 입력하세요");
				int fixNameNo = scan.nextInt();
				System.out.println("수정하실 과목 번호를 입력하세요");
				System.out.printf("1.국어\n2.영어\n3.수학\n");
				int fixSubNo = scan.nextInt();
				switch (fixSubNo) {
				case 1:
					System.out.printf("현재 %s 학생 국어 점수 : %d점\n", stuInfo[fixNameNo].name, stuInfo[fixNameNo].kor);
					System.out.println("수정할 점수를 입력하세요");
					stuInfo[fixNameNo].kor = scan.nextInt();
					break;
				case 2:
					System.out.printf("현재 %s 학생 영어 점수 : %d점\n", stuInfo[fixNameNo].name, stuInfo[fixNameNo].eng);
					System.out.println("수정할 점수를 입력하세요");
					stuInfo[fixNameNo].eng = scan.nextInt();
					break;
				case 3:
					System.out.printf("현재 %s 학생 수학 점수 : %d점\n", stuInfo[fixNameNo].name, stuInfo[fixNameNo].math);
					System.out.println("수정할 점수를 입력하세요");
					stuInfo[fixNameNo].math = scan.nextInt();
					break;
				default:
					System.out.println("숫자를 잘못입력하셨습니다.");
					break;
				}
				stuInfo[fixNameNo].total = stuInfo[fixNameNo].kor + stuInfo[fixNameNo].eng + stuInfo[fixNameNo].math;
				stuInfo[fixNameNo].avg = (double) stuInfo[fixNameNo].total / 3;
				break;
			case 4:
				System.out.println("[ 학생성적 검색]");
				System.out.println("검색하실 학생이름을 입력해 주세요");
				String findName = scan.next();
				int findNameNo = -1;
				System.out.printf("번호\t이름\t국어\t영어\t수학\t합계\t평균\t등수\n");
				for (int i = 0; i < Student.count; i++) {
					if (stuInfo[i].name.contains(findName)) {
						System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", stuInfo[i].stu_num, stuInfo[i].name,
								stuInfo[i].kor, stuInfo[i].eng, stuInfo[i].math, stuInfo[i].total, stuInfo[i].avg,
								stuInfo[i].rank);
						findNameNo = 0;
					}

				}
				if (findNameNo == -1) {
					System.out.println("검색하식 이름이 없습니다");
				}
				break;
			case 5:
				System.out.println("[ 학생성적 등수처리]");
				for (int i = 0; i < Student.count; i++) {
					int rankNum = 1;
					for (int j = 0; j < Student.count; j++) {
						if (stuInfo[i].total < stuInfo[j].total) {
							rankNum++;
						}
						stuInfo[i].rank = rankNum;
					}
				}
				break;
			case 6:
				System.out.println("프로그램 종료");
				break loop1;

			default:
				System.out.println("숫자를 잘못입력 하셨습니다");
				break;
			}// switch - choice

		} // while

	}// main

}// class
