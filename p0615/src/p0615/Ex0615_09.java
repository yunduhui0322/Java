package p0615;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex0615_09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File f1 = new File("c:/work1/f1.txt");
		try{
			FileWriter fw = new FileWriter(f1,true);
			System.out.println("글자를 입력하세요");
			fw.write(sc.nextLine()+ "\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(f1.exists() == false) {
		}
	}

}
