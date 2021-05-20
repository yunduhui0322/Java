
public class Student {
	static int count;
	int stu_num= ++count;
	String name;
	int kor;
	int eng;
	int math;
	int total;
	double avg;
	int rank;
	
	Student(){}
	Student(String n,int k, int e, int m){
		name = n;
		kor = k;
		eng = e;
		math = m;
		total = k+e+m;
		avg = (double)total/3;
	}
	void fixKor(int k) {
		kor = k;
		total = k+eng+math;
		avg = (double)total/3;
	}
	void fixEng(int e) {
		eng = e;
		total = e+kor+math;
		avg = (double)total/3;
	}
	void fixMath(int m) {
		math = m;
		total = m+kor+eng;
		avg = (double)total/3;
	}
	static void input() {
		
	}
}

