import java.util.Scanner;

public class Ex0524_04 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// Triangle 객체 Point 3개를 입력받아 각각의 길이를 구하시오.
		Point[] input_p = new Point[3];
		for (int i = 0; i < input_p.length; i++) {
			input_p[i] = new Point();
			System.out.printf("%d 번째 X,Y좌표를 입력하세요\n", (i + 1));
			//x,y 로 입력하는 방법
			//input_p[i].x = scan.next();
//			System.out.printf("%d 번째 Y좌표를 입력하세요\n", (i + 1));
			String input = scan.next();
			String[] str = input.split(",");//,를 기준으로 분리해서 배열로 리턴
			input_p[i].x = Integer.parseInt(str[0]);
			input_p[i].y = Integer.parseInt(str[1]);
			//'5'-'0' 문자->숫자 /0+"" = ->String
//			input_p[i].y = scan.nextInt();
		}

		Point[] p = { new Point(input_p[0].x, input_p[0].y), new Point(input_p[1].x, input_p[1].y),
				new Point(input_p[2].x, input_p[2].y) };
//		Point[] p = {input_p[0],input_p[1],input_p[2]};
//		Point[] p1 = new Point[3];
//		for (int i = 0; i < p1.length; i++) {
//			p1[i] = new Point(input_p[i].x, input_p[i].y);
//		}
		Triangle t1 = new Triangle(p);
		t1.triangle_Print();
		
		t1.triangle_area();
	}// main
}// class
