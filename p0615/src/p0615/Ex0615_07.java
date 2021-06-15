package p0615;

import java.io.File;
import java.io.IOException;

public class Ex0615_07 {

	public static void main(String[] args) {
		// work1/file폴더 생성
		// work1/f1.txt, f2.txt, f3.txt, f4.txt 파일을 만들어보세요

		String folder = "c:/work1/file/";
		File dir = new File(folder);
		File f1 = new File("c:/work1/file/f1.txt");
		File f2 = new File("c:/work1/file/f2.txt");
		File f3 = new File("c:/work1/file/f3.txt");
		File f4 = new File("c:/work1/file/f4.txt");
		if (dir.exists() == false) {
			dir.mkdirs();
			System.out.println("폴더를 생성합니다.");
		}

		if (f1.exists() == false && f2.exists() == false && f3.exists() == false && f4.exists() == false) {
			try {
				f1.createNewFile();
				f2.createNewFile();
				f3.createNewFile();
				f4.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("파일을 생성합니다.");
		}
		
		File fileName = new File("c:/work1/file");
		File[] f_contents = fileName.listFiles();
		for(int i=0;i<f_contents.length;i++) {
			System.out.printf("%s\n",f_contents[i].getName());
		}
	}//main

}//class
