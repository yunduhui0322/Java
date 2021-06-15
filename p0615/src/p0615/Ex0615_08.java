package p0615;

import java.io.File;
import java.text.SimpleDateFormat;

public class Ex0615_08 {

	public static void main(String[] args) {
		File fileName = new File("c:/Windows/");
		File[] f_contents = fileName.listFiles();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		
		
		for(int i=0; i<f_contents.length; i++) {
			if(f_contents[i].isDirectory()) {
				System.out.printf("<폴더>\t");
			}else {
				System.out.printf("<파일>\t");
			}
			System.out.printf("파일명: %25s\t 날짜: %s\t 파일크기: %sKB\n",f_contents[i].getName(),sdf.format(f_contents[i].lastModified()),f_contents[i].length());
		}
	}//main

}//class
