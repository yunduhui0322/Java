package p0617;

public class Tv {
	private int proNo;
	private String name;
	
	Tv(){}
	Tv(int proNo, String name){
		this.proNo = proNo;
		this.name = name;
		
	}
	public int getProNo() {
		return proNo;
	}
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
