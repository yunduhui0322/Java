package p0621;

import java.util.ArrayList;
import java.util.HashMap;

public class Ex0621_05 {

	public static void main(String[] args) {
		
		ArrayList<Student> arr_list = new ArrayList<Student>();
		MapProcess mp = new MapProcess();
		
		arr_list.add(new Student("홍길동",100,100,100));
		arr_list.add(new Student("리순신",100,100,100));
		arr_list.add(new Student("류관순",100,100,100));
		arr_list.add(new Student("엄복동",100,100,100));
		arr_list.add(new Student("걸캅스",100,100,100));
		arr_list.add(new Student("김옥지",100,100,100));
		
		HashMap map = mp.selectStudent(arr_list);
		
		System.out.println("list모든이름 : " + map.get("strName"));
		System.out.println("result번호 : " + map.get("result"));
		System.out.println("result결과 : " + map.get("resultTitle"));
		System.out.println("검색결과 이름 : " + map.get("name"));
	}

}
