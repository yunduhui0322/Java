package p0621;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex0621_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> arr_stu = new ArrayList<Student>();
		StringBuffer sbf = new StringBuffer("");
		//1. 홍길동 100 100 100
		//2. 이순신 90 90 90
		//3. 유관순 99 99 98
		//4. 강감찬 80 80 89
		//5. 김구 100 100 99
		//6. 김유신 70 70 79
		//7. 이율곡 99 99 100
		//7명의 ArrayList에 학생 성적을 넣은 후
		//이름을 StringBuffer에 ","로 구분해서 저장할것
		//이름을 출력할것
		// 2. StringBuffer에 있는 데이터를 각각 분리해서
		//이름을 각각 출력해보세요
		
		while(true) {
			System.out.println("[ 학생성적 프로그램 ]");
			System.out.println("1. 학생성적 입력");
			System.out.println("2. 학생성적 출력");
			
			switch (sc.nextInt()) {
			case 1:
				System.out.println("학생성적 입력하기");
				while(true) {
					String name = "";
					int kor = 0, eng =0, math = 0;
					System.out.println("이름을 입력하세요");
					name = sc.next();
					if(name.equals("0")) {
						System.out.println("상위메뉴로 이동합니다.");
						break;
					}
					System.out.println("국어성적을 입력하세요");
					kor = sc.nextInt();
					System.out.println("영어성적을 입력하세요");
					eng = sc.nextInt();
					System.out.println("수학성적을 입력하세요");
					math = sc.nextInt();
					arr_stu.add(new Student(name,kor,eng,math));
				}
				break;
			case 2:
				for(int i=0; i<arr_stu.size(); i++) {
					if(i==0) {
						sbf.append(arr_stu.get(i).getName());
					}else {
						sbf.append(","+ arr_stu.get(i).getName());
					}
				}
				String[] str = sbf.toString().split(",");
				
				for(String s : str) {
					System.out.println(s);
				}
				System.out.println("===================================================");
				for(Student s : arr_stu) {
					System.out.printf("%s,%s,%d,%d,%d,%d,%.2f\n",s.getStuNo(),s.getName(),s.getKor(),s.getEng(),s.getMath(),s.getTotal(),s.getAvg());
				}
				
				break;

			default:
				break;
			}
		}
		
				
	}

}
