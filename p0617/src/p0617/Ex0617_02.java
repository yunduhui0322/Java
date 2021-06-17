package p0617;

import java.util.Scanner;

public class Ex0617_02 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] fileName = {"windows","Windows","winDows","Win","window","Window",
				"wins"};
		//windows -> 대소문자 구분없이 검색해서 검색된 단어 출력, 개수출력
		//win이 포함되어있는 단어를 대소문자 구분없이 검색,개수출력
		//s로끝나는 단어를 검색출력,개수 출력을 해보세요,
		
		int count = 0;
		System.out.println("검색하실 단어를 입력하세요");
		String input = sc.next();
		System.out.println("1.대소문자 구분없이 같은문자 검색\n2.검색된 단어가 대소문자 없이 검색\n3.검색된 문자로 끝나는 단어 검색\n");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			for(String s : fileName) {
				if(s.equalsIgnoreCase(input)) {
					count++;
					System.out.printf("단어: %s\n",s);
				}
			}
			System.out.printf("%s와 일치하는 단어개수: %d개\n",input,count);
			break;
		case 2:
			for(String s : fileName) {
				if(s.toUpperCase().contains(input.toUpperCase())) {
					count++;
					System.out.printf("단어: %s\n",s);
				}
			}
			System.out.printf("%s가 포함된 단어개수: %d개\n",input,count);
			break;
		case 3:
			for(String s : fileName) {
				if(s.endsWith(input)) {
					count++;
					System.out.printf("단어: %s\n",s);
				}
			}
			System.out.printf("%s로 끝나는 단어개수:%s 개\n",input,count);
			break;

		default:
			break;
		}
		
//		System.out.println("검색할 단어를 입력하세요");
//		int count =0;
//		String input = sc.nextLine();
//		System.out.println("[ 단어검색 ]");
//		for(int i=0; i<fileName.length;i++) {
//			if(fileName[i].equalsIgnoreCase(input)) {
//				count++;
//				System.out.printf("단어: %s\n",fileName[i]);
//			}
//		}
//		for(int i=0; i<fileName.length;i++) {
//			if(fileName[i].toUpperCase().equals(input.toUpperCase())) {
//				count++;
//				System.out.printf("단어: %s\n",fileName[i]);
//			}
//		}
//		
//		System.out.printf("동일한 단어는 : %d 개\n",count);
	}//main
}//class
