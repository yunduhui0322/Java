//import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException   {
//		ArrayList<String> arr = new ArrayList<String>();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		String s = "abcdefg";//출력할 문자열
//		bw.write(s);//출력
//		bw.newLine(); //줄바꿈
//		bw.flush();//남아있는 데이터를 모두 출력시킴
//		bw.close();//스트림을 닫음
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=13; j++) {
				System.out.println(13*(i-1) +(j-1));
			}
		}
	}
}// class
