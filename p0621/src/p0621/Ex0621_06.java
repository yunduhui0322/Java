package p0621;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Ex0621_06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//홍길동, 이순신, 유관순, 강감찬, 김구, 김유신, 이율곡 
		// 검색할 데이터 이름을 입력받아 -> 그 데이터를 MapPro클래스의 메소드에 매개변수로 넘겨서 
		//데이터를 검색한다음
		// main으로 데이터를 넘겨 출력하시오
		//전체이름 데이터, "이름이 검색되었습니다.","이름이 검색되지 않았습니다."
		//성공 "success",fail
		
		ArrayList<Student> arr_stu = new ArrayList<Student>();
		
		arr_stu.add(new Student("홍길동",100,100,100));
		arr_stu.add(new Student("홍길동",100,100,100));
		arr_stu.add(new Student("홍길자",100,100,100));
		arr_stu.add(new Student("홍길순",100,100,100));
		arr_stu.add(new Student("홍길정",100,100,100));
		arr_stu.add(new Student("홍길분",100,100,100));
		
		MapPro mp = new MapPro();
		System.out.println("검색할 학생이름을 입력하세요");
		String name = sc.next();
		HashMap map = mp.findName(arr_stu, name);
		
		System.out.println("전체이름 데이터 :" + map.get("allName"));
		System.out.println("검색 결과 :" + map.get("result"));
		System.out.println("검색 코드 :" + map.get("resultCode"));
		System.out.println("검색한 이름 :" + map.get("name"));
		System.out.println("검색된 이름 :" + map.get("resultName"));
	}

}
