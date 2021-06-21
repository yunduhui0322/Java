package p0616;

public class Ex0616_09 {

	public static void main(String[] args) {
		String[] fileName = {"file1.txt","file2.hwp","file.psd","file4.jpg",
				"file5.ppt","file6.doc","file7.java"};
		//txt -문서파일, hwp-한글문서파일,psd-포토샵파일,jpg-이미지파일,ppt-파워포인트파일
		//doc-워드문서파일,java-java파일
		for(int i=0; i<fileName.length;i++) {
			if(fileName[i].endsWith("txt")) {
				System.out.println("문서파일입니다.");
			}else if(fileName[i].endsWith("hwp")) {
				System.out.println("한글파일 입니다");
			}else if(fileName[i].endsWith("psd")) {
				System.out.println("포토샵파일 입니다");
			}else if(fileName[i].endsWith("jpg")) {
				System.out.println("이미지파일 입니다");
			}else if(fileName[i].endsWith("ppt")) {
				System.out.println("피피티파일 입니다");
			}else if(fileName[i].endsWith("java")) {
				System.out.println("자바파일 입니다");
			}
		}
//		String str = "file1.txt";
//		if(str.endsWith("txt")) {
//			System.out.println("txt로 끝납니다");
//		}else {
//			System.out.println("텍스트 문서파일 노노");
//		}
	}//main

}//class
