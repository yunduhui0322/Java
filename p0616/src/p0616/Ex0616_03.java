package p0616;

public class Ex0616_03 {

	public static void main(String[] args) {
		String str = "1,2,3,4,5,6,7,8,9";
		
		String[] str1 = str.split(",");
		for(int i=0; i<str1.length;i++) {
			System.out.println(str1[i]);
		}
	}

}
