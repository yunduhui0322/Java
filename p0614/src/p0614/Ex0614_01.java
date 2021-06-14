package p0614;

import java.util.Scanner;

public class Ex0614_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stu s = new Stu("S001","10김김","김도한","종로의아들");
		
		System.out.println("비밀번호를 입력하세요");
		if(s.name.equals(sc.next())&&s.pw.equals(sc.next())) {
			System.out.println("비밀번호가 같습니다.");
			System.out.println(s);
		}else {
			System.out.println("비밀번호가 다릅니다.");
		}
//		int[] arr1 = {10,20,30,40,50,60,70,80,90,100};
//		String[] str1 = {"자동차","배","마차","비행기","오토바이","자전거","킥보드"};
//		for(String s : str1) {
//			System.out.println(s);
//		}
//		for(int a :arr1) {
//			System.out.println(a);
//		}
	}

}
