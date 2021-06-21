package p0621;

import java.util.HashSet;
import java.util.Iterator;

public class Ex0621_03 {

	public static void main(String[] args) {
		HashSet<Student> set = new HashSet<Student>();
		Student s = new Student("홍길동",100,100,100);
		set.add(s);
		s = new Student("이순신",90,90,90);
		set.add(s);
		s= new Student("유관순",100,100,100);
		set.add(s);
		set.add(new Student("김구",100,100,100));
		set.add(new Student("김유신",100,100,100));
		
		
		Iterator<Student> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.printf(itr.next().getName());
		}
		
		
	}

}
