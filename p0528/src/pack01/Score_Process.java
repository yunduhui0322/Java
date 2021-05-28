package pack01;

import java.util.ArrayList;
import java.util.Scanner;

public class Score_Process {

	Scanner scan = new Scanner(System.in);

	void mainPrint() {
		System.out.println("[ 학생성적 프로그램 ]");
		System.out.println("1.학생성적 추가");
		System.out.println("2.학생성적 출력");
		System.out.println("3.학생성적 수정");
		System.out.println("4.학생성적 검색");
		System.out.println("5.학생등수 처리");
		System.out.println("6.학생성적 삭제");
		System.out.println("0.프로그램 종료");
		System.out.println("원하시는 번호를 입력하세요");
	}// main Print

	void student_score_insert(ArrayList<Student> arr_stu) {
		System.out.println("[ 학생성적 추가 ]");
		while (true) {
			String name = "";
			int kor, eng, math = 0;

			System.out.println("학생이름을 입력하세요(0.상위메뉴 이동)");
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
			arr_stu.add(new Student(name, kor, eng, math));
		} // while
	}// student_score_insert

	void top_title() {
		System.out.println("번호\t이름\t국어\t영어\t수학\t합계\t평균\t등수");
	}

	void student_score_print(ArrayList<Student> arr_stu) {
		if(arr_stu.isEmpty()) {
			System.out.println("정보가 없습니다 학생성적을 추가해주세요");
			return;
		}
		System.out.println("[ 학생성적 출력 ]");
		top_title();
		for (int i = 0; i < arr_stu.size(); i++) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", arr_stu.get(i).getStu_num(),
					arr_stu.get(i).getName(), arr_stu.get(i).getKor(), arr_stu.get(i).getEng(),
					arr_stu.get(i).getMath(), arr_stu.get(i).getTotal(), arr_stu.get(i).getAvg(),
					arr_stu.get(i).getRank());
		}

	}// student_socre_print

	void student_score_update(ArrayList<Student> arr_stu) {
		if(arr_stu.isEmpty()) {
			System.out.println("정보가 없습니다 학생성적을 추가해주세요");
			return;
		}
		String searchName = "";
		int searchNameNo = 0;
		int updateNameNo = 0;
		int updateSubNo = 0;
		System.out.println("[ 학생성적 수정 ]");
		System.out.println("수정하실 학생이름을 입력해주세요");
		searchName = scan.next();
		searchNameNo = -1;
		for (int i = 0; i < arr_stu.size(); i++) {
			if (arr_stu.get(i).getName().contains(searchName)) {
				System.out.printf("%d. %s\n", (i + 1), arr_stu.get(i).getName());
				searchNameNo = 0;
			}
		}
		if (searchNameNo == -1) {
			System.out.println("찾으시는 학생이름이 존재하지 않습니다.");
			return;
		}
		System.out.println("수정하실 학생 번호를 입력해주세요");
		updateNameNo = scan.nextInt();
		System.out.println("수정하실 과목번호를 입력해주세요");
		System.out.printf("1.국어\n2.영어\n3.수학\n");
		updateSubNo = scan.nextInt();
		switch (updateSubNo) {
		case 1:
			System.out.printf("현재 국어점수:%d점\n수정하실 점수를 입력해주세요\n", arr_stu.get(updateNameNo - 1).getKor());
			arr_stu.get(updateNameNo - 1).setKor(scan.nextInt());
			break;
		case 2:
			System.out.printf("현재 영어점수:%d점\n수정하실 점수를 입력해주세요\n", arr_stu.get(updateNameNo - 1).getEng());
			arr_stu.get(updateNameNo - 1).setEng(scan.nextInt());
			break;
		case 3:
			System.out.printf("현재 수학점수:%d점\n수정하실 점수를 입력해주세요\n", arr_stu.get(updateNameNo - 1).getMath());
			arr_stu.get(updateNameNo - 1).setMath(scan.nextInt());
			break;

		}
		System.out.println("점수수정이 완료되었습니다.");
	}// student_score_update

	void student_score_select(ArrayList<Student> arr_stu) {
		if(arr_stu.isEmpty()) {
			System.out.println("정보가 없습니다 학생성적을 추가해주세요");
			return;
		}
		String findName = "";
		int findNameNo = 0;
		System.out.println("검색하실 학생이름을 입력하세요");
		findName = scan.next();
		top_title();
		findNameNo = -1;
		for (int i = 0; i < arr_stu.size(); i++) {
			if (arr_stu.get(i).getName().contains(findName)) {
				System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", arr_stu.get(i).getStu_num(),
						arr_stu.get(i).getName(), arr_stu.get(i).getKor(), arr_stu.get(i).getEng(),
						arr_stu.get(i).getMath(), arr_stu.get(i).getTotal(), arr_stu.get(i).getAvg(),
						arr_stu.get(i).getRank());
			}
		}
		if (findNameNo == -1) {
			System.out.println("검색하신 학생이 존재하지 않습니다.");
		}
	}// student_score_select

	void score_rank_process(ArrayList<Student> arr_stu) {
		if(arr_stu.isEmpty()) {
			System.out.println("정보가 없습니다 학생성적을 추가해주세요");
			return;
		}
		for (int i = 0; i < arr_stu.size(); i++) {
			int rankNo = 1;
			for (int j = 0; j < arr_stu.size(); j++) {
				if(arr_stu.get(i).getTotal()<arr_stu.get(j).getTotal()) {
					rankNo++;
				}
			}
			arr_stu.get(i).setRank(rankNo);
		}
	}// score_rank_process
	
	void student_score_delete(ArrayList<Student> arr_stu) {
		if(arr_stu.isEmpty()) {
			System.out.println("정보가 없습니다 학생성적을 추가해주세요");
			return;
		}
		System.out.printf("\t");
		top_title();
		for (int i = 0; i < arr_stu.size(); i++) {
			System.out.printf("번호:%d\t%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", (i + 1), arr_stu.get(i).getStu_num(),
					arr_stu.get(i).getName(), arr_stu.get(i).getKor(), arr_stu.get(i).getEng(),
					arr_stu.get(i).getMath(), arr_stu.get(i).getTotal(), arr_stu.get(i).getAvg(),
					arr_stu.get(i).getRank());
		}
		System.out.println("삭제하실 학생 번호를 입력하세요");
		int delete_stu = 0;
		delete_stu = scan.nextInt();
		System.out.printf("%s학생이 삭제되었습니다\n", arr_stu.get(delete_stu - 1).getStu_num());
		arr_stu.remove(delete_stu - 1);
		if(arr_stu.isEmpty()) {
			System.out.println("학생성적정보가 없습니다 학생성적을 추가해주세요");
			return;
		}
	}
}
