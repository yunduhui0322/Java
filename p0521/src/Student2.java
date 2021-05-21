
public class Student2 {
	static int count;
	String stu_number;
	String name;
	int kor,eng,math,total,rank;
	double avg;
	
	{
		stu_number = "S" + String.format("%03d", ++count);
	}
	Student2(){
		
	}//생성자
	Student2(String name, int kor, int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.avg = (double)this.total/3;
				
	}
}
