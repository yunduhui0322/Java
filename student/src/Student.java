
public class Student {
	static int count;
	String name;
	String stu_number;
	int kor,eng,math,total,rank;
	double avg;
	
	{
		stu_number = "S" + String.format("%03d", ++count);
	}
	
	Student(){
		
	}
	Student(String name, int kor, int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		this.total = kor + eng + math;
		this.avg = (double)this.total/3;
	}
}
