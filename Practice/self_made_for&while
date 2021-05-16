import java.util.Scanner;
public class self0516 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 학생 5명 국 영 수 합계 평균
		String[] name = new String[5];
		String[] sub = {"국어","영어","수학"};
		int[][] score = new int[5][4];
		double[] avg = new double[5];
		
		String check = "";
		String checkName = "";//이름확인
		String checkSub = "";//과목확인
		
		int count = 0;
		int searchNameNo = 0;
		int searchSubNo = 0;
		loop1:while(true) {
			System.out.println("[ 성적처리 프로그램 ]");
			System.out.println("1.성적 입력");
			System.out.println("2.성적 수정");
			System.out.println("3.성적 출력");
			System.out.println("4.성적 검색");
			System.out.println("0.프로그램 종료");
			System.out.println("원하시는 번호를 입력하세요");
			
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("[ 성적 입력 ]");
				for (int i=count; i<name.length; i++) {
					System.out.println("이름을 입력하세요");
					System.out.println("[0을 입력하시면 상위메뉴로 이동합니다.]");
					
					check = scan.next();
					if(check.equals("0")) {
						break;
					}
					name[i] = check;
					for(int j=0; j<score[i].length-1; j++) {
						System.out.printf("%s점수를 입력하세요%n",sub[j]);
						score[i][j]  = scan.nextInt();
						score[i][score[i].length-1] += score[i][j];
					}
					avg[i] = (double)score[i][score[i].length-1]/(score[i].length-1);
					count++;
				}
				break;
			case 2:
				System.out.println("[ 성적 수정 ]");
				System.out.println("수정하실 학생의 이름을 입력하세요");
				checkName = scan.next();
				
				searchNameNo = -1;
				
				for(int i =0; i<count; i++) {
					if(checkName.equals(name[i])) {
						searchNameNo = i;
					}
				}
				System.out.printf("%s 의 학생의 정보를 수정합니다%n",name[searchNameNo]);
				
				//이름이 없을 경우
				if(searchNameNo == -1){
					System.out.println("입력하신 학생의 이름이 없습니다");
					break;
				}
				
				searchSubNo = -1;
				
				System.out.printf("%s 학생의 수정할 과목을 입력하세요%n",name[searchNameNo]);
				checkSub = scan.next();
				for(int i =0; i<sub.length; i++) {
					if(checkSub.equals(sub[i])) {
						searchSubNo = i;					}
					
				}
				System.out.printf("%s 학생의 %s점수를 수정합니다%n",name[searchNameNo],sub[searchSubNo]);
				if(searchSubNo == -1) {
					System.out.println("입력하신 과목이 없습니다");
					break;
				}
					
				System.out.printf("현재 %s 학생의 %s점수 : %d점%n", name[searchNameNo],sub[searchSubNo],score[searchNameNo][searchSubNo]);
				System.out.printf("수정할  %s점수를 입력하세요%n",sub[searchSubNo]);
				
				score[searchNameNo][searchSubNo] = scan.nextInt();
				score[searchNameNo][score[searchNameNo].length-1] = 0;
				
				for(int i =0; i<score[i].length-1; i++) {
					score[searchNameNo][score[searchNameNo].length-1] += score[searchNameNo][i];
				}
				avg[searchNameNo] = (double)score[searchNameNo][score[searchNameNo].length-1]/sub.length;
				
				break;
			case 3:
				System.out.printf("이름\t국어\t영어\t수학\t합계\t평군\n");
				for (int i=0; i<count; i++) {
					System.out.printf("%s\t",name[i]);
					for(int j=0; j<score[i].length; j++) {
						System.out.printf("%d\t",score[i][j]);
					}
					System.out.printf("%.2f%n",avg[i]);
				}
				break;
			case 4:
				System.out.println("[ 성적 검색 ]");
				System.out.println("검색하실 학생의 이름을 입력해주세요");
				checkName = scan.next();
				
				searchNameNo = -1;
				
				for(int i =0; i<count; i++) {
					if(checkName.equals(name[i])) {
						searchNameNo = i;
					}
				}
				System.out.printf("%s 의 학생의 정보를 검색합니다%n",name[searchNameNo]);
				
				//이름이 없을 경우
				if(searchNameNo == -1){
					System.out.println("검색하신 학생의 정보가 없습니다");
					break;
				}
				
				searchSubNo = -1;
				
				System.out.printf("%s 학생의 검색할 과목을 입력하세요%n",name[searchNameNo]);
				checkSub = scan.next();
				for(int i =0; i<sub.length; i++) {
					if(checkSub.equals(sub[i])) {
						searchSubNo = i;					
					}
					
				}
				
				if(searchSubNo == -1) {
					if(checkSub.equals("합계")) {
						System.out.printf("%s의 합계 점수 : %d%n",name[searchNameNo],score[searchNameNo][sub.length]);
					}
					else if(checkSub.equals("평균")){
						System.out.printf("%s의 평균 점수 : %.2f%n",name[searchNameNo],avg[searchNameNo]);
					}
					else {
						System.out.println("입력하신 과목이 없습니다");
						break;
						
					}
				}
				else {
					System.out.printf("%s 학생의 %s점수: %d %n",name[searchNameNo],sub[searchSubNo],score[searchNameNo][searchSubNo]);
					
				}
				//영어
				//수학
				//합계
				//평균
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				break loop1;
			default:
				break;
			}
			
		}//while
	}//main

}//class
