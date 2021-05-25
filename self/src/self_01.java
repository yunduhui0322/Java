import java.util.Scanner;
public class self_01 {
public static void main(String[] args) {
	// 학생 성적 프로그램 
	// 원하는 학생수를 입력해서 출력해보세요
	// 이름 을 입력받고 국어 영어 수학 합계 /평균을 출력 하세요
	// 원하는 과목 개수 입력받기
	
	Scanner scan  = new Scanner(System.in);
	
	// 원하는 학생수 입력
	System.out.println("학생 수를 입력해 주세요");
	int s_no = scan.nextInt();
	
	//학생 이름 배열 생성
	String[] name = new String[s_no];
	
	//입력할 과목개수+합계(1)
	System.out.println("과목 수를 입력해 주세요");
	int s_sco = scan.nextInt();
	int[][] score = new int[s_no][s_sco+1];
	
	double[] avg = new double[s_no];
	
	
	//이름 입력 배열 생성
	for(int i=0; i<s_no; i++) {
		System.out.printf("\n%d번째 학생이름을 입력해주세요 %n",(i+1));
		name[i] = scan.next();
		for(int j =0; j<s_sco; j++) {
		System.out.printf("학생 %s의 %d번째 점수를 입력해주세요\n", name[i],(j+1));
		score[i][j] = scan.nextInt();
		score[i][s_sco] += score[i][j];//total
		}
		avg[i] = (double)score[i][s_sco]/s_sco;
	}//for
	
	//출력
	for(int i=0; i<s_no; i++) {
		System.out.printf("%s\t",name[i]);
		for(int j = 0; j<score[i].length; j++) {
			System.out.printf("%d\t ", score[i][j]);
		}
		System.out.printf("%.2f",avg[i]);
		System.out.println();
	}
	
	
 }//main		
		
}//class
