
public class Triangle extends Shape {

	Point[] p;
	double[] length = new double[3];

	Triangle() {

	}

	Triangle(Point[] p ) {
		this.p = p;
	}

	Triangle(Point p1, Point p2, Point p3) {
		p = new Point[] { p1, p2, p3 };
	}

	void triangle_Print() {

		for (int i = 0; i < p.length; i++) {
			System.out.printf("%d번째 x,y좌표 : %d , %d \n", (i + 1), p[i].x, p[i].y);
			if (i < 2) {
				length[i] = Math.sqrt(Math.pow((p[i].x - p[i + 1].x), 2) + Math.pow((p[i].y - p[i + 1].y), 2));
			} else {
				length[i] = Math.sqrt(Math.pow((p[i].x - p[i - 2].x), 2) + Math.pow((p[i].y - p[i - 2].y), 2));
			}
			System.out.printf("%d번째 길이 : %.2f\n", (i + 1), length[i]);
		}
	}//triangle_Print method
	
	//삼각형 넓이 출력
	void triangle_area() {
		//반둘레 구하는 공식 s = 0.5*(length1+length2+length3)
		double s = 0.5*(length[0] + length[1] + length[2]);
		
		double tri_area = Math.sqrt(s*(s-length[0])*(s-length[1])*(s-length[2]));
		System.out.printf("삼각형의 넓이 : %.2f",tri_area);
		
		
		
	}//triangle_area
}