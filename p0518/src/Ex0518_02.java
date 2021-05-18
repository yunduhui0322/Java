import java.util.Scanner;
public class Ex0518_02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		Student s1 = new Student();
//		Student s2 = new Student();
//		Student s3 = new Student();
//		
		Student[]s = new Student[2];
		//객체배열선언
//		s[0] = new Student();
//		s[1] = new Student();
		//3명의 학생의 성적입력
		for(int i=0; i<s.length; i++) {
			s[i] = new Student();
			System.out.println("이름을 입력하세요");
			s[i].name = scan.next();
			//점수입력(국어,영어,수학,3개)
			for(int j=0; j<s[i].score.length; j++) {
				System.out.println("점수를 입력하세요");
				s[i].score[j] = scan.nextInt();
				s[i].total += s[i].score[j];
			}
			s[i].avg = (double)s[i].total/3;
			
		}
		for(int i=0; i<s.length; i++) {
			System.out.printf("%d :",s[i].stu_number);
			System.out.printf("%s\t",s[i].name);
			//점수입력(국어,영어,수학,3개)
			for(int j=0; j<s[i].score.length; j++) {
				System.out.printf("%d\t",s[i].score[j]);
			}
			System.out.printf("%d\t%.2f\n",s[i].total,s[i].avg);
		}
//		s[0].total = s[0].kor + s[0].eng + s[0].math;
		
//		s[0].avg = (double)s[0].total/3;
//		
//		Student[] grade = new Student[5];
//		grade[0] = new Student();
//		
//		for(int i=0; i<grade.length; i++) {
//			grade[i] = new Student();
//			grade[i].name = scan.next();
//			grade[i].kor = scan.nextInt();
//			grade[i].eng = scan.nextInt();
//			grade[i].math = scan.nextInt();
//			grade[i].total = grade[i].kor + grade[i].eng + grade[i].math;
//			grade[i].avg = (double)grade[i].total/3;
//		}
	}//main
}//class
