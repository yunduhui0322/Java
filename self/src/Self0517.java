import java.util.Scanner;

public class Self0517 {
	public static void main(String[] args) {
		// 학생 수 s_num , 과목수 sub_num
		// title M+4

		Scanner scan = new Scanner(System.in);

		System.out.println("학생 수를 입력하세요");
		int s_num = scan.nextInt();
		System.out.println("과목수를 입력하세요");
		int sub_num = scan.nextInt();

		String[] sub = new String[sub_num];
		for (int i = 0; i < sub.length; i++) {
			System.out.println("과목명을 입력하세요");
			sub[i] = scan.next();
		}
		String[] name = new String[s_num];
		int[][] score = new int[s_num][sub_num + 1];
		int[] rank = new int[s_num];
		double[] avg = new double[s_num];

		String check = "";// 상위메뉴이동
		String searchName = "";// 이름 검색
		String fixName = "";//수정할이름
		String fixSub = "";// 수정할과목

		int choice = 0;
		int count = 0;
		int searchNameNum = 0;
		int fixNameNo = 0;
		int fixSubNo = 0;
		int searchNameNo = 0;
		loop1: while (true) {
			System.out.println("\n[ 학생성적 처리프로그램 ]");
			System.out.println("1.학생성적 추가");
			System.out.println("2.학생성적 출력");
			System.out.println("3.학생성적 수정");
			System.out.println("4.학생성적 검색");
			System.out.println("5.학생성적 등수");
			System.out.println("6.프로그램 종료");

			choice = scan.nextInt();
			switch (choice) {
			case 1:// 학생 성적 추가
				for (int i = count; i < s_num; i++) {
					System.out.println("이름을 입력하세요(0.상위메뉴 이동)");
					check = scan.next();
					if (check.equals("0")) {
						System.out.println("상위메뉴로 이동합니다");
						break;
					}
					name[i] = check;
					for (int j = 0; j < sub_num; j++) {
						System.out.printf("%s의 %s점수를 입력하세요\n", name[i], sub[j]);
						score[i][j] = scan.nextInt();
						score[i][sub_num] += score[i][j];
					}
					avg[i] = (double) score[i][sub_num] / sub_num;
					count++;
				}

				break;
			case 2:// 학생성적 출력
				System.out.print("\n이름\t");
				for (int i = 0; i < sub.length; i++) {
					System.out.printf("%s\t", sub[i]);
				}
				System.out.println("합계\t평균\t등수");
				for (int i = 0; i < count; i++) {
					System.out.printf("%s\t", name[i]);
					for (int j = 0; j <= sub_num; j++) {
						System.out.printf("%d\t", score[i][j]);
					}
					System.out.printf("%.2f\t", avg[i]);
					System.out.printf("%d\n", rank[i]);
				}
				break;
			case 3:// 학생성적 수정
				System.out.println("검색할 학생의 이름을 입력하세요");
				searchName = scan.next();
				System.out.println("일치하는 학생이름");
				for (int i = 0; i < count; i++) {
					if (name[i].contains(searchName)) {
						searchNameNum = i;
						System.out.printf("[%s]", name[i]);
					}
				}
				System.out.println();
				System.out.println("수정할 학생이름을  입력하세요");
				fixName = scan.next();
				for (int j = 0; j < count; j++) {
					if (fixName.equals(name[j])) {
						fixNameNo = j;

					}
				}
				System.out.println("수정할 과목을 입력하세요");
				for (int i = 0; i < sub.length; i++) {
					System.out.printf("%d. %s\n", (i + 1), sub[i]);
				}
				fixSub = scan.next();
				for (int i = 0; i < sub.length; i++) {
					if (fixSub.equals(sub[i])) {
						fixSubNo = i;
					}
				}
				System.out.println("수정할 점수를 입력하세요");
				System.out.printf("현재 %s 점수: %d점", sub[fixSubNo], score[fixNameNo][fixSubNo]);
				System.out.println();
				score[fixNameNo][sub_num] = 0;
				score[fixNameNo][fixSubNo] = scan.nextInt();
				for (int i = 0; i < sub_num; i++) {
					score[fixNameNo][sub_num] += score[fixNameNo][i];
				}
				avg[fixNameNo] = score[fixNameNo][sub_num] / sub_num;
				System.out.println("성적수정이 완료되었습니다");
				break;
			case 4:
				System.out.println("[학생 성적검색]");
				System.out.println("검색할 학생의 이름을 입력해주세요");
				searchNameNum = -1;
				searchName = scan.next();
				System.out.println("일치하는 학생이름");
				for (int i = 0; i < count; i++) {
					if (name[i].contains(searchName)) {
						searchNameNum = i;
						System.out.printf("[%s]", name[i]);
						
					}
				}
				
				if(searchNameNum == -1) {
					System.out.println("일치하는 학생이 없습니다");
					break;
				}
				
				System.out.println();
				System.out.println("성적을 확인할 학생이름을  입력하세요");
				fixName = scan.next();

				for (int i = 0; i < count; i++) {
					if (fixName.equals(name[i])) {
						fixNameNo = i;
						break;
					}
				}
				System.out.print("\n이름\t");
				for (int i = 0; i < sub.length; i++) {
					System.out.printf("%s\t", sub[i]);
				}
				System.out.println("합계\t평균\t등수");

				System.out.println();
				for (int j = fixNameNo; j <= fixNameNo; j++) {
					System.out.printf("%s\t", name[j]);
					for (int k = 0; k <= sub_num; k++) {
						System.out.printf("%d\t", score[j][k]);
					}
					System.out.printf("%.2f\t", avg[j]);
					System.out.printf("%d", rank[j]);
				}

				System.out.println();
				if (searchNameNo == -1) {
					System.out.println("이름이 없습니다");
					break;
				}

				break;
			case 5:
				for (int i = 0; i < count; i++) {
					int rankNum = 1;
					for (int j = 0; j < count; j++) {
						if (score[i][sub_num] < score[j][sub_num]) {
							rankNum++;
						}

					}
					rank[i] = rankNum;
				}
				System.out.println("등수처리가 완료되었습니다.");
				break;
			case 6:
				System.out.println("프로그램을 종료합니다");
				break loop1;

			default:
				System.out.println("번호를 잘못입력하셨습니다. 다시입력해주세요");
				break;
			}
		} // while

	}// main
}// class
