
public class Student2 {
	
	static int count;//초기화 하지 않아도 됨-> 인스턴스,클래스변수 자동으로 초기화해 줌
	
	// c001, k001, s001
	int stu_number = ++count;//객체가 생성되는순간 count가 1씩 증가된다 
	String name;
	int kor;
	int eng;
	int math;
	int total;
	double avg;
	int rank;
}
