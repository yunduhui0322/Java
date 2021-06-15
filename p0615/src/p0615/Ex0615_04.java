package p0615;

public class Ex0615_04 {

	public static void main(String[] args) {
		
		try {
			startInstall();
			copyFiles();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			deleteTempfiles();
		}//try-catch
	}//main
	static void startInstall() {System.out.println("파일설치");}
	static void copyFiles() {System.out.println("파일백업");}
	static void deleteTempfiles() {System.out.println("임시파일 삭제");}
}//class
