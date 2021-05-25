
public class Student {
	
	
	static int count;
	{
		this.stu_num = "S"+String.format("%03d", ++count);
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
	private String stu_num;
	private String name;
	private int kor,eng,math,total,rank;
	private double avg;
	public String getStu_num() {
		return stu_num;
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
		this.total = this.kor + this.eng + this.math;
		this.avg = (double)this.total/3;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
		this.total = this.kor + this.eng + this.math;
		this.avg = (double)this.total/3;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
		this.total = this.kor + this.eng + this.math;
		this.avg = (double)this.total/3;
	}
	public int getTotal() {
		return total;
	}
	public int getRank() {
		return rank;
	}
	public double getAvg() {
		return avg;
	}
	
	
	
}



