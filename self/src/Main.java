import java.util.ArrayList;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
////import java.util.ArrayList;
////import java.util.StringTokenizer;
//import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)    {
//		ArrayList<String> arr = new ArrayList<String>();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		String s = "abcdefg";//출력할 문자열
//		bw.write(s);//출력
//		bw.newLine(); //줄바꿈
//		bw.flush();//남아있는 데이터를 모두 출력시킴
//		bw.close();//스트림을 닫음
//		for(int i=1; i<=4; i++) {
//			for(int j=1; j<=13; j++) {
//				System.out.println(13*(i-1) +(j-1));
//			}
//		}
//		StringBuffer str = new StringBuffer("");
//		str.append("abc");
		String str = "1+2-3*4/5";
		String a = (str.substring(str.lastIndexOf("*")-1,str.lastIndexOf("*")+2));
		String s = (str.charAt(str.lastIndexOf("*")-1)-'0')*(str.charAt(str.lastIndexOf("*")+1)-'0')+"";
		str = str.replace(a, s);
		System.out.println(str);
		System.out.println(str.lastIndexOf("+"));
		System.out.println(str.lastIndexOf("-"));
		System.out.println(str.lastIndexOf("*"));
		System.out.println(str.lastIndexOf("/"));
		
//		for(Character c : number) {
//			System.out.println(c);
//			
//		}
//		for(Character s : cal) {
//			System.out.println(s);
//	
//		}
//		String result = str.substring(str.lastIndexOf("+")+1);
//		String str1 = "ABCD/DEFGH";
//		String result1 = str1.substring(str1.lastIndexOf("/")+1);
//		System.out.println(result1); 
//		int result = number.get(0)-'0'+ number.get(1)-'0';
//		System.out.println(result);
		
		
	}//main
	static void Calculator(String str) {
//		ArrayList<Character> number = new ArrayList<Character>();
//		ArrayList<Character> cal = new ArrayList<Character>();
//		for(int i=0; i<str.length();i++) {
//			if(Character.isDigit(str.charAt(i))) {
//				number.add(str.charAt(i));
//			}else {
//				cal.add(str.charAt(i));
//			}
//		}
		int result = 0;
			if(str.contains("*")) {
				result += (str.charAt(str.lastIndexOf("*")-1)-'0') * (str.charAt(str.lastIndexOf("*")+1)-'0');
				str = str.replace(str.substring(str.lastIndexOf("*")-1,str.lastIndexOf("*")+2), result+"");
			}
		
	}

}// class
