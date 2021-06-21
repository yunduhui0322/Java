package p0621;

import java.util.ArrayList;
import java.util.HashMap;

public class MapProcess {
	
	public HashMap selectStudent(ArrayList<Student> arr_stu) {
		HashMap map  = new HashMap();
		StringBuffer sbf = new StringBuffer();
		int result = 0;//0: 데이터가 없음, 1: 데이터가 있음. 
		String name  = "";
		String resultTitle = "실패";
		for(Student s : arr_stu) {
			sbf.append(s.getName()+ " ");
			if(s.getName().equals("홍길동")) {
				result = 1;
				resultTitle = "성공";
				name = "홍길동";
			}
		}
		
		String strName = sbf.toString();
		map.put("strName", strName);
		map.put("result", result);
		map.put("name", name);
		map.put("resultTitle", resultTitle);
		return map;
	}
}
