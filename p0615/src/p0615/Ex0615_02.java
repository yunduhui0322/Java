package p0615;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex0615_02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int count = 0;
		while (true) {
			System.out.printf("%d번쨰 데이터를 입력하세요\n",(count+1));
			list.add(sc.nextInt());
			System.out.printf("%d번쨰 데이터값: %d\n",(count+1),list.get(count));
			count++;
		}//런타임에러

//		System.out.println("예외처리를 하고있습니다");
//		System.out.prinln("예외처리를 하고있습니다"); 컴파일 에러==>>예외처리 X
	}// main

}// class
