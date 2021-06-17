package p0617;


import java.util.Scanner;

public class Ex0617_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] fileName = {"windows","Windows","winDows","Win","window","Window",
				"wins"};
		int count = 0;
		System.out.println("검색하실 단어를 입력하세요");
		String input = sc.nextLine().trim();
		input = input.replaceAll(" ","");
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

//		String[] fileName = {"windows","Windows","winDows","Win","window","Window",
//		"wins"};
//		
//		for(int i=0; i<fileName.length;i++) {
//			fileName[i] =fileName[i].replace("win", "Win");
//			System.out.println(fileName[i]);
//		}
//		Scanner sc = new Scanner(System.in);
//		String str = "abcdefghijklmnopqrstuvwxyz";
//		String result = str.replace("fgh", "fff");
//		System.out.println(result);
//		while(true) {
//			System.out.println("찾고자하는문자를 입력하세요");
//			String input = sc.next();
//			if(input.length()>4) {
//				System.out.println("3자리 이하를 입력하셔야 합니다.");
//				continue;
//			}
//			int index = str.indexOf(input);
//			System.out.printf("%s 찾는문자 :%d\n",input,index);
//		}
		
	}//main

}//class
