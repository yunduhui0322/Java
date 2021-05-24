
public class Circle extends Shape{

	Point center;//객체주소 참조변수
	int r;
	
	Circle(){
		this(new Point(0,0),100);
	}
	Circle(Point center, int r){
		this.center = center;
		this.r = r;
				
	}
}
