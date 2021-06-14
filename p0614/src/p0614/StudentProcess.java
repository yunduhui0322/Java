package p0614;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentProcess {
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Student> arr_stu = new ArrayList<Student>();

	
	public void main_print() {
		System.out.println("[ 학생성적 프로그램 ]");
		System.out.println("1.학생성적 추가");
		System.out.println("2.학생성적 출력");
		System.out.println("3.학생성적 수정");
		System.out.println("4.학생성적 검색");
		System.out.println("5.학생등수 처리");
		System.out.println("0. 프로그램종료");
		System.out.println("원하시는 번호를 입력하세요");
	}// main_print
	
	public void insert_score() {
		while(true) {
			
			String name = "";
			int kor,eng,math = 0;
			System.out.println("이름을 입력하세요(0.상위메뉴 이동)");
			name = sc.next();
			if(name.equals("0")) {
				System.out.println("상위메뉴로 이동합니다");
				return;
			}
			System.out.println("국어점수를 입력하세요");
			kor = sc.nextInt();
			System.out.println("영어점수를 입력하세요");
			eng = sc.nextInt();
			System.out.println("수학점수를 입력하세요");
			math = sc.nextInt();
			
			arr_stu.add(new Student(name,kor,eng,math));
		}
	}//insert_score
	public void title() {
		System.out.printf("번호\t이름\t국어\t영어\t수학\t합계\t평균\t등수\n");
	}
	public void score_print() {
		title();
		for(Student s : arr_stu) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",s.getStu_number(),s.getName(),
					s.getKor(),s.getEng(),s.getMath(),s.getTotal(),s.getAvg(),s.getRank());
		}
	}//score_print
	
	public void update_score() {
		String searchName = "";
		int searchNameNo = 0;
		int fixNameNo = 0;
		int fixSubNo = 0;
		System.out.println("수정할 학생이름을 검색하세요");
		searchName = sc.next();
		searchNameNo = -1;
		for(int i=0; i<arr_stu.size(); i++) {
			if(arr_stu.get(i).getName().contains(searchName)) {
				System.out.printf("%d. %s\n",(i+1),arr_stu.get(i).getName());
				searchNameNo = 0;
			}
		}
		if(searchNameNo == -1) {
			System.out.println("검색하신 학생이름이 존재하지 않습니다.");
			return;
		}
		System.out.println("수정하실 학생번호를 입력하세요");
		fixNameNo = sc.nextInt();
		System.out.printf("1.국어\n2.영어\n3.수학\n수정하실 과목번호를 입력하세요");
		fixSubNo = sc.nextInt();
		
		switch (fixSubNo) {
		case 1:
			System.out.printf("현재 국어점수: %d점\n수정하실 점수를 입력하세요\n",arr_stu.get(fixNameNo-1).getKor());
			arr_stu.get(fixNameNo-1).setKor(sc.nextInt());
			System.out.println("점수수정이 완료되었습니다");
			break;
		case 2:
			System.out.printf("현재 영어점수: %d점\n수정하실 점수를 입력하세요\n",arr_stu.get(fixNameNo-1).getEng());
			arr_stu.get(fixNameNo-1).setEng(sc.nextInt());
			System.out.println("점수수정이 완료되었습니다");
			break;
		case 3:
			System.out.printf("현재 수학점수: %d점\n수정하실 점수를 입력하세요\n",arr_stu.get(fixNameNo-1).getMath());
			arr_stu.get(fixNameNo-1).setMath(sc.nextInt());
			System.out.println("점수수정이 완료되었습니다");
			break;

		default:
			break;
		}
		
		
	}//update_score
	
	public void search_student() {
		String findName = "";
		int findNameNo = 0;
		System.out.println("검색하실 학생이름을 입력하세요");
		findName = sc.next();
		findNameNo = -1;
		title();
		for(int i=0; i<arr_stu.size(); i++) {
			if(arr_stu.get(i).getName().contains(findName)) {
				System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",
						arr_stu.get(i).getStu_number(),arr_stu.get(i).getName(),arr_stu.get(i).getKor(),arr_stu.get(i).getEng(),
						arr_stu.get(i).getMath(),arr_stu.get(i).getTotal(),arr_stu.get(i).getAvg(),arr_stu.get(i).getRank());
				findNameNo = 0;
			}
		}
		if(findNameNo == -1) {
			System.out.println("찾으시는 학생이름이 존재하지 않습니다.");
			return;
		}
	}//serach_student
	
	public void rank_process() {
		for(int i=0; i<arr_stu.size(); i++) {
			int rankNum = 1;
			for(int j=0; j<arr_stu.size(); j++) {
				if(arr_stu.get(i).getTotal()<arr_stu.get(j).getTotal()) {
					rankNum++;
				}
			}
			arr_stu.get(i).setRank(rankNum);
		}
		System.out.println("등수처리가 완료되었습니다");
	}//rank_process
}
