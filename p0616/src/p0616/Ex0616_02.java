package p0616;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Ex0616_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File file1 = new File("c:/temp01/student.txt");
		//데이터
		int count = 0,stu_number = 0,kor = 0,eng,math = 0,total = 0;
		double avg = 0;
		String name = "";
		//파일저장 임시변수
		String content="";
		while(count <2) {
			System.out.println("학번을 입력하세요.>>");
			stu_number = sc.nextInt();
			content += stu_number +",";
			System.out.println("이름을 입력하세요.>>");
			name = sc.next();
			content += name +",";
			System.out.println("국어점수를 입력하세요");
			kor = sc.nextInt();
			content += kor +",";
			System.out.println("영어점수를 입력하세요");
			eng = sc.nextInt();
			content += eng +",";
			System.out.println("수학점수를 입력하세요");
			math = sc.nextInt();
			content += math +",";		
			total = kor + eng + math;
			content += total +",";		
			avg = (double)total/3;
			content += avg ;	
			//파일저장
			try {
				if(!file1.exists()) {
					file1.createNewFile();
				}
				FileWriter fw = new FileWriter(file1,true);
				fw.write(content +"\r\n");
				fw.flush();
				fw.close();
				content = "";
				System.out.println("파일이 저장되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}
			count++;
		}//while
		try {
			Scanner sc2 = new Scanner(file1);
			String str = "";
			//전체 데이터 출력
			while(sc2.hasNextLine()) {//현재 읽어들일 한줄의 데이터가 있는지 확인메소ㅡ드
				str += sc2.nextLine() + ",";
			}
			System.out.println(str);
			//각각 데이터 출력
			String[] arr = str.split(",");
			for(int i=0; i<arr.length; i++) {
				System.out.println(arr[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}//main

}//class
