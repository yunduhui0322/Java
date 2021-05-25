
public class Singleton {

	private static Singleton s = new Singleton();//날짜 쓸때 사용
	static int count;
	private int stu_num;
	private String name;
	{
		count++;
		stu_num = count;
	}
	
	private Singleton() {
		
	}
	public static Singleton getInstance() {
		if(s==null) {
			s = new Singleton();
		}//메모리에 존재하지 않을때 생성해준다.
		return s;
	}
	public int getStu_num() {
		return stu_num;
	}

	public void setStu_num(int stu_num) {
		this.stu_num = stu_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
