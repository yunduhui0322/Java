package p0617;

import java.util.List;
import java.util.ArrayList;

public class Ex0617_08 {

	public static void main(String[] args) {
		List l = null;
		
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(new Student("이순신",10,10,20));
		list.add(2);
		list.add("aaa");
		list.add(12.5);
		list.add(new Student("이순신",10,10,20));
		
		System.out.println(list.get(0));
		System.out.println(((Student)list.get(1)).getName());
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		System.out.println(list.get(5));
	}

}
