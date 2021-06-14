package p0614;

import java.util.ArrayList;

public class Ex0614_02 {

	public static void main(String[] args) {
		ArrayList<Stu> list = new ArrayList<Stu>();
		Stu s1 = new Stu();
		s1.stu_num = "S001";
		s1.name = "김두한";
		s1.pw = "duhui22";
		s1.nickName = "종로의 주먹";
		Stu s2 = new Stu("S002","dudu","시라소니","칼잽이");
		Stu s3 = new Stu("S003","duhui1234","쌍칼","쌍칼잽이");
		Stu s4 = new Stu("S004","444","마루오까","일본주먹");
		Stu s5 = new Stu("S005","5555","김도한","짭두한");
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		
		for(Stu a : list) {
			System.out.println(a);
//			System.out.printf("이름 :%s , 닉네임 :%s, 비밀번호 : %s, 번호 : %s\n",a.name,a.nickName,a.pw,a.stu_num);
//			System.out.printf("학번 : %s, 이름 : %s , 닉네임: %s\n",a.stu_num,a.name,a.nickName);
		}
		
		//향상for문 -배열,ArrayList
//		int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
//		for( int i : arr1) {
//			System.out.println(i);
//		}
//		
//		char[] ch = {'a','b','c'};
//		
//		for( char c : ch) {
//			System.out.println(c);
//		}
//		
	}

}
