
public class Ex0521_05 {
	public static void main(String[] args) {
		String num = "";
		int count = 0;

		// s001,s002
//		System.out.printf("%03d\n",5);
//		System.out.printf("S%03d",11);
		String str_num = "S" + String.format("%03d",++count);
		System.out.println(str_num);
		
		
	}//main
}//class
