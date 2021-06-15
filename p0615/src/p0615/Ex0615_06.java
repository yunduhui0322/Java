package p0615;

import java.io.File;
import java.io.IOException;

public class Ex0615_06 {

	public static void main(String[] args) {
		String filePath = "c:/work/file/";
		File dir1 = new File(filePath);
		File file1 = new File("c:/work/file/file1.txt");
		
		if(dir1.exists()== false) {
			dir1.mkdirs();
			System.out.println("폴더를 생성했습니다");
		}
		if(file1.exists() == false) {
			try {
				file1.createNewFile();
				System.out.println("파일이 생성되었습니다.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		dir1.mkdir();//-> c:/work 라는 폴더가 꼭 있어야 에러나지 않음
//		dir1.mkdirs();//-> c:/work가 없으면 work를 만들고,file폴더를 만들어줌
//		try {
//			file1.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}//main

}//class
