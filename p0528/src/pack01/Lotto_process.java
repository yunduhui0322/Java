package pack01;

import java.util.Scanner;

public class Lotto_process {
	Scanner sc = new Scanner(System.in);
	int[] lottoBall = new int[45];
	int[] myBall = new int[6];
	int[] six_lotto_ball = new int[6];	
	int[] correct_my_ball = new int[6];
	int count;
	Lotto_process() {
		for(int i=0; i<lottoBall.length;i++) {
			lottoBall[i] = i+1;
		}
		for(int i=0; i<1000;i++) {
			int random_num = (int)(Math.random()*45);
			int temp = lottoBall[0];
			lottoBall[0] = lottoBall[random_num];
			lottoBall[random_num] = temp;
		}
	}
	
	void mainPrint() {
		System.out.println("[ 로또 프로그램 ]");
		System.out.println("1. 로또 개인번호6개 생성");
		System.out.println("2. 로또번호 당첨번호 출력");
		System.out.println("원하는 번호를 입력하세요");
	}
	
	void input_six_ball() {
		for(int i=0; i<myBall.length;i++) {
			System.out.printf("%d번쨰 로또번호를 입력해주세요\n",(i+1));
			int input = sc.nextInt();
			myBall[i] = input;
		}
	}//input_six_ball
	
	void correct_lotto(Lotto_process p) {
		System.out.println("[ 로또번호 ]");
		for(int i=0; i<6;i++) {
			System.out.printf("%d\t",lottoBall[i]);
			if(myBall[i] == lottoBall[i]) {
				correct_my_ball[i] = myBall[i];
				count++;
		}
		
		}
		System.out.println();
	System.out.printf("로또맞은 개수:%d개\n ",count);
	System.out.println("[ 당첨번호 ]");
	for(int i=0; i<count;i++) {
		System.out.printf("%d\t",myBall[i]);
	}
	System.out.println();
	}// correct_lotto
}
