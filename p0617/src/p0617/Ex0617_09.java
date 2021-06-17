package p0617;

import java.util.HashSet;
import java.util.Iterator;

public class Ex0617_09 {

	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add(1);
		hs.add(2);
		hs.add(3);
		hs.add(new Tv(1,"OLEDTV"));
		hs.add(4);
		hs.add(new Tv(2,"OLEDTV"));
		hs.add(5);
		hs.add(new Student("윤두희",10,10,10));
		
		Iterator itr = hs.iterator();//set컬렉션에서 Iterator객체를 가져옴.//1회성
		while(itr.hasNext()) { //hasNext():읽어올 데이터가 있는지 확인
			Object o = itr.next();
			if(o instanceof Student) {
				System.out.println(((Student)o).getName());
				
			}else if(o instanceof Tv) {
				System.out.println(((Tv)o).getName());
			}else {
				System.out.printf("데이터 :%d\n",o);//next():객체를 1개 가져옴
				
			}
		}
		hs.remove(3);
			
	}//main
	
}//class
