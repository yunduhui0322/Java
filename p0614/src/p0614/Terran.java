package p0614;

import java.util.ArrayList;

abstract public class Terran {
	int x,y;
	ArrayList<Terran> arr_ter = new ArrayList<Terran>();
	abstract void move(int x, int y);
	void stop() {
		System.out.println("그자리에서 멈춥니다.");
	}
	
	
	
}
