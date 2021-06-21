package p0621;

public class Ex0621_01 {

	public static void main(String[] args) {
		
		String[] str = {"홍길동","이순신","유관순","강감찬","김유신"};
		
		
		StringBuffer sbf = new StringBuffer("");
		
		for(int i=0; i<str.length; i++) {
			if(i == 0) {
				sbf.append(str[i]);
			}else {
				sbf.append(","+str[i]);
				
			}
		}
		String[] str2 = sbf.toString().split(",");
		
		for(String s : str2) {
			System.out.println(s);
		}
	}//main

}//class
