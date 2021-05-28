package pack01;

import java.util.Scanner;

public class Ex0528_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lotto_process p = new Lotto_process();
		while(true) {
			p.mainPrint();
			int choice = sc.nextInt();
		switch (choice) {
		case 1:
			p.input_six_ball();
			break;
		case 2:
			p.correct_lotto(p);
			break;
		case 3:
			
			break;

		default:
			break;
		}
		}
	}//main
}//class
