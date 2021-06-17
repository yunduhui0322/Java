package p0617;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreProcess {
	int save_count = 0;
	Scanner sc = new Scanner(System.in);
	ArrayList <Student> arr_stu = new ArrayList<Student>();
	File dir1 = new File("c:/Student/");
	File file = new File("c:/Student/Score.txt");
	File save_point = new File("c:/Student/Save_Point.txt");
	public void mainPirnt() {
		System.out.println("[ 학생성적 프로그램 ]");
		System.out.println("1.학생성적 추가");
		System.out.println("2.학생성적 출력");
		System.out.println("3.학생성적 수정");
		System.out.println("4.학생성적 검색");
		System.out.println("5.학생등수 처리");
		System.out.println("6.학생저장 파일 불러오기");
		System.out.println("7.학생점수 파일로 저장하기");
		System.out.println("0.프로그램 종료");
		System.out.println("원하시는 번호를 입력하세요");
	}//mainPirnt
	
	public void title() {
		System.out.printf("번호\t이름\t국어\t영어\t수학\t합계\t평균\t등수\n");
	}// title
	
	public void socreInsert() {
		while(true) {
			String name = "";
			int kor =0, eng = 0, math = 0;
			System.out.println("이름을 입력하세요(0.상위메뉴 이동)");
			name = sc.next();
			if(name.equals("0")) {
				System.out.println("상위메뉴로 이동합니다.");
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
	}//scoreInsert
	
	public void scorePrint() {
		title();
		for(Student s : arr_stu) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",s.getStu_num(),s.getName(),s.getKor(),s.getEng(),s.getMath(),s.getTotal(),s.getAvg(),s.getRank());
		}
	}//scorePrint
	
	public void scoreUpdate() {
		String searchName = "";
		int searchNameNo = 0;
		int fixName = 0;
		int fixSubNo = 0;
		System.out.println("수정하실 학생 이름을 입력하세요");
		searchName = sc.next();
		searchNameNo = -1;
		for(int i=0; i<arr_stu.size();i++) {
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
		fixName = sc.nextInt();
		System.out.println("1.국어\n2.영어\n3.수학\n수정하실 과목번호를 입력하세요");
		fixSubNo = sc.nextInt();
		
		switch (fixSubNo) {
		case 1:
			System.out.printf("현재 국어점수: %d점\n수정하실점수를 입력하세요\n",arr_stu.get(fixName-1).getKor());
			arr_stu.get(fixName-1).setKor(sc.nextInt());
			break;
		case 2:
			System.out.printf("현재 영어점수: %d점\n수정하실점수를 입력하세요\n",arr_stu.get(fixName-1).getEng());
			arr_stu.get(fixName-1).setEng(sc.nextInt());
			break;
		case 3:
			System.out.printf("현재 수학점수: %d점\n수정하실점수를 입력하세요\n",arr_stu.get(fixName-1).getMath());
			arr_stu.get(fixName-1).setMath(sc.nextInt());
			break;

		default:
			System.out.println("잘못입력하셨습니다.");
			break;
		}//switch
		arr_stu.get(fixName-1).setTotal(arr_stu.get(fixName-1).getKor() +arr_stu.get(fixName-1).getEng() +arr_stu.get(fixName-1).getMath() );
		arr_stu.get(fixName-1).setAvg((double)arr_stu.get(fixName-1).getTotal()/3);
	}//scoreUpdate
	
	public void searchStudent() {
		String findName = "";
		int findNameNo = 0;
		System.out.println("검색하실 학생 이름을 입력하세요");
		findName = sc.next();
		title();
		findNameNo = -1;
		for(Student s : arr_stu) {
			if(s.getName().contains(findName)) {
				System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",s.getStu_num(),s.getName(),s.getKor(),s.getEng(),s.getMath(),s.getTotal(),s.getAvg(),s.getRank());
				findNameNo = 0;
			}
				
		}
		if(findNameNo ==-1) {
			System.out.println("찾으시는 학생이름이 없습니다");
			return;
		}
	}//serachStudent
	
	public void rankProcess() {
		for(int i=0; i<arr_stu.size();i++) {
			int rankNo = 1;
			for(int j=0; j<arr_stu.size();j++) {
				if(arr_stu.get(i).getTotal()<arr_stu.get(j).getTotal()) {
					rankNo++;
				}
				arr_stu.get(i).setRank(rankNo);
			}
		}
	}//rankPorcess
	@SuppressWarnings("resource")
	public void save_file() {
		if(!dir1.exists()) {
			dir1.mkdirs();
		}
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!save_point.exists()) {
			try {
				save_point.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String save_file_contents = "";
		String save_point_count = "";
		try {
			for(int i=0; i<arr_stu.size();i++) {
				save_file_contents += arr_stu.get(i).getStu_num() + ",";
				save_file_contents += arr_stu.get(i).getName() + ",";
				save_file_contents += arr_stu.get(i).getKor() + ",";
				save_file_contents += arr_stu.get(i).getEng() + ",";
				save_file_contents += arr_stu.get(i).getMath() + ",";
				save_file_contents += arr_stu.get(i).getTotal() + ",";
				save_file_contents += arr_stu.get(i).getAvg() + ",";
				if(i ==(arr_stu.size()-1)) {
					save_file_contents += arr_stu.get(i).getRank() ;
					FileWriter fw = new FileWriter(file);
					FileWriter fw2 = new FileWriter(save_point);
					save_count = arr_stu.size();
					save_point_count += save_count;
					fw.write(save_file_contents);
					fw.flush();
					fw2.write(save_point_count);
					fw2.flush();
					fw.close();
					return;
				}
				save_file_contents += arr_stu.get(i).getRank() + ",";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void load_file() {
		File dir = new File("c:/Student");
		File[] dir_list = dir.listFiles();
		//폴더안 파일보여주고
		for(int i=0; i<dir_list.length;i++) {
			System.out.printf("학생성적 파일:%s\n",dir_list[i].getName());
		}
		System.out.println("불러올 파일명을 모두입력하세요");
		String load_file =sc.next(); 
		//불러올 파일 받아오기
		File file0 = new File("c:/Student/Save_Point.txt");
		int save_count_real = 0;
		try {
			Scanner scan2 = new Scanner(file0);
			save_count_real = Integer.parseInt(scan2.next());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(save_count_real);
		File file = new File("c:/Student/"+load_file);
		try {
			Scanner scan = new Scanner(file);
			String str = "";
			while(scan.hasNextLine()) {
					str = scan.nextLine();
			}
			String[] temp = new String[save_count_real * 8];
			temp = str.split(",");
			for(int i=0,j=0; i<save_count_real; i++,j+=8) {
				arr_stu.add(new Student(temp[j+1], Integer.parseInt(temp[j+2]),Integer.parseInt(temp[j+3]),Integer.parseInt(temp[j+4])));
			}
			rankProcess();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
