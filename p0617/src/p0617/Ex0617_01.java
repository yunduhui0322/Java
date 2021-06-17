package p0617;

import java.io.File;
import java.util.Scanner;

public class Ex0617_01 {

	public static void main(String[] args) {
		//work1 폴더에 txt파일이 몇개있는지 출력해보세요
		Scanner sc = new Scanner(System.in);
		System.out.println("찾을려는 주소를 입력하세요");
		
		File dir = new File(sc.nextLine());
		
		
		File[] f_name = dir.listFiles();
		int find_count = 0;
		System.out.println("찾으려고하는 파일확장자명을 입력하세요");
		String ext = sc.next();
		System.out.println("1.포함되어있는형태 검색\n2.검색한 문자로 끝나는 형태");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.printf( "[ %s가 포함된 파일명 ]\n",ext);
			for(int i=0; i<f_name.length;i++) {
				if(f_name[i].getName().contains(ext)) {
					find_count++;
					System.out.printf("%s\n",f_name[i].getName());
				}
			}
			System.out.printf("%s가 포함된 파일 개수: %d개",ext,find_count);
			break;
		case 2:
			for(int i=0; i<f_name.length; i++) {
				if(f_name[i].getName().endsWith(ext)) {
					find_count++;
				}
			}
			System.out.printf("%s파일 개수: %d개",ext,find_count);
			
			break;

		default:
			break;
		}
//		File dir = new File("c:/work1/");
//		
//		File[] f_contents = dir.listFiles();
//		int count = 0;
//		for(int i=0; i<f_contents.length; i++) {
//			if(f_contents[i].getName().endsWith("txt")) {
//				count++;
//			}
//		}
//		System.out.printf("txt 파일개수 : %d개\n",count);
	}

}
