package p0616;

public class Ex0616_08 {

	public static void main(String[] args) {
		
		String[] hobby1 = {"game","movie","reading","golf"};
		String[] hobby2 = {"game"};
		String[] hobby3 = {"game","movie"};
		//db저장하는 방법
		//1개의 데이터로 변경을 해야 합니다.
		//String hobby <- hobby1의배열 1개의 String으로 묶어서 저장해보세요
		String hobbys = "";
		for(int i=0; i<hobby1.length;i++) {
			if(i == hobby1.length-1) {
				hobbys += hobby1[i];
				break;
			}
			hobbys += hobby1[i] +",";
		}
		System.out.println(hobbys);
		
		if(hobbys.contains("game")) {
			System.out.println("게임 checked 활성화");
			System.out.println("<input type='checkbox' name='hobby' value='game' checked>");
		}else {
			System.out.println("게임 checked 비활성화");
			System.out.println("<input type='checkbox' name='hobby' value='game'>");
		}
//		String[] stu_num = new String[100];
//		for(int i=0; i<100;i++) {//s0001,s0002
//			
////			stu_num[i] =String.format("S%04d", (i+1));
//		}
//		for(int i=0; i<100;i++) {//s0001,s0002
//			System.out.println(stu_num[i]);
//		}
	}//main

}//class
