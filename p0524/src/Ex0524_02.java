
public class Ex0524_02 {
	
	public static void main(String[] args) {
		Circle c1 = new Circle();
		System.out.println("c1의 x,y 좌표: " + c1.center.x + "," + c1.center.y);
		System.out.println("c1의 반지름: " + c1.r);
		System.out.println("c1의 넓이: " + (Math.pow(c1.r,2)*3.14));
		//Math pow-제곱 sqrt-루트 
		
		Circle c2 = new Circle(new Point(150,150),50);
		//x,y좌표 , 반지름 , 넓이를 구하시오
		System.out.printf("x좌표 : %d, y 좌표 %d: 반지름 %d: , 넓이 :%.2f\n",c2.center.x,c2.center.y
				,c2.r,(Math.pow(c2.r,2)*3.14));
		
		Point[] p = {new Point(0,0),
					 new Point(100,0),
					 new Point(100,100)};
		
		Triangle t1 = new Triangle(p);
		System.out.printf("t1의 첫번째 좌표 : %d,%d\n"
				+ "t1의 두번째 좌표 : %d,%d\n"
				+ "t1의 세번째 좌표 : %d,%d\n",t1.p[0].x,t1.p[0].y,t1.p[1].x,t1.p[1].y,t1.p[2].x,t1.p[2].x);
		int x_length = t1.p[1].x - t1.p[0].x;
		int y_length = t1.p[2].y - t1.p[0].y;
		double xyPow = Math.pow(x_length,2) + Math.pow(y_length,2);
		double value = Math.sqrt(xyPow);
		System.out.println("x좌표의길이 : " + x_length);
		System.out.println("y좌표의길이 : " + y_length);
		System.out.println("대각선의 길이 : " + value );
	}//main
}//class
