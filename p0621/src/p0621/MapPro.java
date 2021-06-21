package p0621;

import java.util.ArrayList;
import java.util.HashMap;

public class MapPro {

	public HashMap findName(ArrayList<Student> list, String name) {
		StringBuffer sbf = new StringBuffer("");
		HashMap map = new HashMap();
		String result = "이름이 검색되지 않았습니다.";
		String resultCode = "fail";
		StringBuffer allName = new StringBuffer("");
		for(Student s : list){
			allName.append(s.getName() + " ");
			if(s.getName().contains(name)) {
				resultCode = "Success";
				result = "이름이 검색되었습니다";
				sbf.append(s.getName()+ " ");
				
			}
//			if(!resultCode.equals("Success")) {
//				resultCode = "fail";
//				result = "이름이 검색되지않았습니다.";
//			}
		}
		map.put("result", result);
		map.put("resultCode", resultCode);
		map.put("allName", allName.toString());
		map.put("resultName", sbf.toString());
		map.put("name", name);
		return map;
	}
	
	
}
