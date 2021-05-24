import java.util.Scanner;

public class Ex0524_03 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		Point[] in_point = new Point[3];
		for(int i=0; i<in_point.length; i++) {
			in_point[i] = new Point();
			System.out.println((i+1) + "번째 x좌표를입력하세요");
			in_point[i].x = scan.nextInt();
			System.out.println((i+1) + "번째 y좌표를입력하세요");
			in_point[i].y = scan.nextInt();
		}//좌표 3개 입력받음.
		
//		System.out.println("1번째 X좌표를 입력하세요");
//		int x1 = scan.nextInt();
//		System.out.println("1번째 Y좌표를 입력하세요");
//		int y1 = scan.nextInt();
//
//		System.out.println("2번째 X좌표를 입력하세요");
//		int x2 = scan.nextInt();
//		System.out.println("2번째 Y좌표를 입력하세요");
//		int y2 = scan.nextInt();
//
//		System.out.println("3번째 X좌표를 입력하세요");
//		int x3 = scan.nextInt();
//		System.out.println("3번째 Y좌표를 입력하세요");
//		int y3 = scan.nextInt();
		Point[] p = { new Point(in_point[0].x, in_point[0].y), new Point(in_point[1].x, in_point[1].y), new Point(in_point[2].x, in_point[2].y) };
//		for(int i=0; i<in_point.length; i++) {
//			Point[] p = {new Point(in_point[i].x,in_point[i].y)};
//		}
		Triangle t1 = new Triangle(p);
//		System.out.printf("x1,y1 좌표 : %d , %d\n" + "x2,y2 좌표 : %d , %d\n" + "x3,y3 좌표 : %d , %d\n", t1.p[0].x,
//				t1.p[0].y, t1.p[1].x, t1.p[1].y, t1.p[2].x, t1.p[2].y);
		double[] point_length = new double[3];
		for(int i=0; i<p.length; i++) {
			if(i<2) {
				point_length[i] = Math.sqrt(Math.pow((t1.p[i].x - t1.p[i+1].x), 2) + Math.pow((t1.p[i].y - t1.p[i+1].y), 2));
			}
			else {
				
				point_length[i] = Math.sqrt(Math.pow((t1.p[i].x - t1.p[i-2].x), 2) + Math.pow((t1.p[i].y - t1.p[i-2].y), 2));
			}
			System.out.printf("%d번째 길이 : %.2f\n",(i+1),point_length[i]);
		}
//		double xx = Math.pow((t1.p[0].x - t1.p[1].x), 2);
//		double yy = Math.pow((t1.p[0].y - t1.p[1].y), 2);
//		// x1,y1 에서 x2,y2 까지의 길이
//		double length1 = Math.sqrt((xx + yy));
//
//		// x2,y2 에서 x3,y3까지의 길이
//		double xx2 = Math.pow((t1.p[1].x - t1.p[2].x), 2);
//		double yy2 = Math.pow((t1.p[1].y - t1.p[2].y), 2);
//
//		double length2 = Math.sqrt((xx2 + yy2));
//		// x3,y3 에서 x1,y1 까지의길이
//		double xx3 = Math.pow((t1.p[2].x - t1.p[0].x), 2);
//		double yy3 = Math.pow((t1.p[2].y - t1.p[0].y), 2);
//
//		double length3 = Math.sqrt((xx3 + yy3));
//		System.out.printf("x1,y1에서 x2,y2까지의 길이 : %f\n" + "x2,y2에서 x3,y3까지의 길이 : %f\n" + "x3,y3에서 x1,y1까지의 길이 : %f",
//				length1, length2, length3);
	}// main
}// class
