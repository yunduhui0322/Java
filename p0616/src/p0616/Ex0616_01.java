package p0616;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex0616_01 {

	public static void main(String[] args) {
		//폴더생성
		File dir1 = new File("c:/temp01/directory");
		if(!dir1.exists()) {
			dir1.mkdirs();
		}
		//파일생성
		
		File file1 = new File("c:/temp01/file1.txt");
		if(file1.exists()) {
			try {
				file1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//글자저장
		try {
			FileWriter fw = new FileWriter(file1,true);//true -->> 뒷부분에 추가해서 쓴다.
			String str = "다음수업은 JSP웹프로그래밍 입니다.\n";
			fw.write(str);// \r은 마지막줄로 이동
			fw.flush();//버퍼에 기록되어 있는 내용을 모두 저장시키는 명령어.
			fw.close();
			System.out.println("글자가 입력되었습니다");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//글자 읽기
		try {
			Scanner sc = new Scanner(file1);//System.in:화면으로 입력,File ->파일로입력
			String str = "";
			while(sc.hasNextLine()) {
				str += sc.nextLine() +"\n";
			}
			
			File file2 = new File("c:/temp01/file2.txt");
			if(!file2.exists()) {
				file2.createNewFile();
			}
			
			FileWriter fw2 = new FileWriter(file2);
			fw2.write(str);
			fw2.flush();
			fw2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//main

}//class
