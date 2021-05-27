package self;

import java.util.ArrayList;
import java.util.Scanner;

public class Student_Program {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> arr_stu = new ArrayList<Student>();

	void mainPrint() {
		System.out.println("[ 학생성적 프로그램 ]");
		System.out.println("1. 학생성적 추가");
		System.out.println("2. 학생성적 출력");
		System.out.println("3. 학생성적 수정");
		System.out.println("4. 학생성적 검색");
		System.out.println("5. 학생등수 처리");
		System.out.println("6. 학생성적 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.println("원하는 번호를 입력하세요");
	}

	void student_score_insert() {
		while (true) {
			String name = "";
			int kor, eng, math = 0;
			System.out.println("학생이름을 입력하세요(0.상위메뉴 이동)");
			name = scan.next();
			if (name.equals("0")) {
				System.out.println("상위메뉴로 이동합니다");
				break;
			}
			System.out.println("국어성적을 입력하세요");
			kor = scan.nextInt();
			System.out.println("영어성적을 입력하세요");
			eng = scan.nextInt();
			System.out.println("수학성적을 입력하세요");
			math = scan.nextInt();

			arr_stu.add(new Student(name, kor, eng, math));

		}
	}// student_score_insert

	void top_title() {
		System.out.printf("번호\t이름\t국어\t영어\t수학\t합계\t평균\t등수\n");
	}

	void student_score_print() {
		top_title();
		for (int i = 0; i < arr_stu.size(); i++) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", arr_stu.get(i).getStu_num(),
					arr_stu.get(i).getName(), arr_stu.get(i).getKor(), arr_stu.get(i).getEng(),
					arr_stu.get(i).getMath(), arr_stu.get(i).getTotal(), arr_stu.get(i).getAvg(),
					arr_stu.get(i).getRank());
		}
	}// student_score_print

	void student_socre_update() {
		String searchName = "";
		int fixNameNo = 0;
		int fixSubNo = 0;
		int searchNameNo = 0;
		System.out.println("수정하실 학생이름을 입력하세요");
		searchName = scan.next();
		searchNameNo = -1;
		for (int i = 0; i < arr_stu.size(); i++) {
			if (arr_stu.get(i).getName().contains(searchName)) {
				System.out.printf("%d. %s\n", (i + 1), arr_stu.get(i).getName());
				searchNameNo = 0;
			}
		}
		if (searchNameNo == -1) {
			System.out.println("입력하신 학생이름이 존재하지 않습니다");
			return;
		}
		System.out.println("수정하실 학생번호를 입력하세요");
		fixNameNo = scan.nextInt();
		System.out.println("수정하실 과목 번호를 입력하세요");
		System.out.printf("1.국어\n2.영어\n3.수학\n");
		fixSubNo = scan.nextInt();
		switch (fixSubNo) {
		case 1:
			System.out.printf("현재 국어점수:%d점\n수정하실 점수를 입력하세요\n", arr_stu.get(fixNameNo - 1).getKor());
			arr_stu.get(fixNameNo - 1).setKor(scan.nextInt());
			break;
		case 2:
			System.out.printf("현재 영어점수:%d점\n수정하실 점수를 입력하세요\n", arr_stu.get(fixNameNo - 1).getEng());
			arr_stu.get(fixNameNo - 1).setEng(scan.nextInt());
			break;
		case 3:
			System.out.printf("현재 국어점수:%d점\n수정하실 점수를 입력하세요\n", arr_stu.get(fixNameNo - 1).getMath());
			arr_stu.get(fixNameNo - 1).setMath(scan.nextInt());
			break;

		}
		student_score_rank_process();
		System.out.println("점수수정이 완료되었습니다.");
	}// student_score_update

	void student_score_select() {
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
			findNameNo = 0;
			}
		}
		if(findNameNo == -1) {
			System.out.println("검색하신 학생이름이 없습니다.");
			return;
		}
	}//student_score_select
	
	void student_score_rank_process() {
		for(int i=0; i<arr_stu.size();i++) {
			int rankNo = 1;
			for(int j=0;j<arr_stu.size();j++) {
				if(arr_stu.get(i).getTotal()<arr_stu.get(j).getTotal()) {
					rankNo++;
				}
			}
			arr_stu.get(i).setRank(rankNo);
		}
	}//student_score_rank_process
	
	void student_score_delete() {
		top_title();
		for (int i = 0; i < arr_stu.size(); i++) {
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",(i+1),
					arr_stu.get(i).getName(), arr_stu.get(i).getKor(), arr_stu.get(i).getEng(),
					arr_stu.get(i).getMath(), arr_stu.get(i).getTotal(), arr_stu.get(i).getAvg(),
					arr_stu.get(i).getRank());
		}
		System.out.println("삭제하실 학생 번호를 고르세요");
		int delete_stu = scan.nextInt();
		System.out.printf("번호%s학생이 삭제되었습니다\n",arr_stu.get(delete_stu-1).getStu_num());
		arr_stu.remove(delete_stu-1);
	}//student_score_delete
}
