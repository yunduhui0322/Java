
public class Ex0525_05 {

	public static void main(String[] args) {
		Student s = new Student("홍길동",100,100,99);
		System.out.printf("번호 :%s\n이름 : %s\n국어점수 :%d점\n",s.getStu_num(),s.getName(),s.getKor());
		s.setKor(90);
		System.out.printf("수정 국어점수 : %d",s.getKor());
	}//main
}//class
