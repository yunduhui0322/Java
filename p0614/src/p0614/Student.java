package p0614;

public class Student {

	static int count;
	private String name,stu_number;
	private int kor,eng,math,total,rank;
	private double avg;
	{
		stu_number = String.format("S%03d", ++count);
	}
	
	Student(){
		
	}
	
	Student(String name, int kor, int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.avg = (double)total/3;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStu_number() {
		return stu_number;
	}

	public void setStu_number(String stu_number) {
		this.stu_number = stu_number;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		this.total = kor + eng + math;
		this.avg = (double)total/3;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		this.total = kor + eng + math;
		this.avg = (double)total/3;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
		this.total = kor + eng + math;
		this.avg = (double)total/3;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
}
