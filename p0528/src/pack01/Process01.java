package pack01;

import java.util.ArrayList;
import java.util.Scanner;

public class Process01 {
	Scanner scan = new Scanner(System.in);

//	ArrayList<Integer>list = new ArrayList<Integer>();
	int plus(ArrayList<Integer> list) {
		System.out.println("두수를 입력하세요");
		int total = list.get(0) + list.get(1);
		return total;
	};

	int sum(ArrayList<Integer> list) {
		int total = 0;
		for (int i = list.get(0); i <= list.get(1); i++) {
			total += i;
		}
		return total;
	}
	
	void size(int[] num) {
		if(num[0] > num[1]) {
			System.out.printf("큰수 %d, 작은수 %d\n",num[0],num[1]);
		}else {
			System.out.printf("큰수 %d, 작은수 %d\n",num[1],num[0]);
		}
	}
	void size1(ArrayList<Integer>list) {
		if(list.get(0) > list.get(1)) {
			System.out.printf("큰수 : %d, 작은수 : %d\n",list.get(0),list.get(1));
		}else {
			System.out.printf("큰수 : %d, 작은수 : %d\n",list.get(1),list.get(0));	
			}
	}
	ArrayList<Integer> number_input() {
		System.out.println("두수를 입력하세요");
		ArrayList<Integer> list = new ArrayList<Integer>();
		int a1 = scan.nextInt();
		int b1 = scan.nextInt();
		list.add(a1);
		list.add(b1);

		return list;
	}

	int plus1(int[] num) {
		System.out.println("두수를 입력하세요");
		int total = num[0] + num[1];
		return total;
	};
	int sum2(int[] num) {
		int sum = 0;
		for(int i=num[0]; i<=num[1]; i++) {
			sum += i;
		}
		return sum;
	}
	int[] number_input2() {
		int[] num = new int[2];

		for (int i = 0; i < num.length; i++) {
			System.out.println((i + 1) + "번쨰수를 입력하세요");
			num[i] = scan.nextInt();
		}
		return num;
	}
}
