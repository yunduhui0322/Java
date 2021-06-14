package p0614;

public class Stu {

	String stu_num;
	String pw;
	String name;
	String nickName;
	
	Stu(){
		
	}
	
	Stu(String stu_num, String pw, String name, String nickName){
		this.stu_num = stu_num;
		this.pw = pw;
		this.name = name;
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		String str = "";
		str = "학번 :" + stu_num + "\n이름 :" + name + "\n닉네임 :" + nickName;
		return str;
	}
}
