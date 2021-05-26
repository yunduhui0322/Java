import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex0525_06 {
	public static void main(String[] args) {
		//Calendar 객체사용 private 생성자로인해 객체가 1개 
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();//객체선언을 하지만 여러번해도 값은 똑같다.
		String today3 = sdf3.format(cal.getTime());
		System.out.println(today3);
		
		
		//Date 객체 사용 - 날짜와 시간을 구함.
		Date time = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년MM월dd일 hh시mm분ss초");
		String today = sdf1.format(time);
		System.out.println(today);
		
		Date time2 = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String today2 = sdf2.format(time2);
		System.out.println(today2);
//		Singleton s = Singleton.getInstance();
//		Singleton s1 = Singleton.getInstance();
//		s1.setName("윤두희");
//		s.setName("홍길동");
//		System.out.println(s.getStu_num()+s.getName());
//		System.out.println(s1.getName() + s1.getStu_num());
	}//main
}//class
