package p0617;

public class Ex0617_05 {

	public static void main(String[] args) {
		String str = new String("aaa");
		
		
		StringBuffer str3 = new StringBuffer("aa");
		
		str += "bbb";
		System.out.println(str);
		str3.append("ccc");
		System.out.println(str3);
		str3.insert(1,"b");
		System.out.println(str3);
		str3.delete(0, 3);
		System.out.println(str3);
		str3.deleteCharAt(2);
		System.out.println(str3);
		System.out.println("현재 저장공간 크기 보는명령어:"+str3.capacity());
	}

}
