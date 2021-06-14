package p0614;

public class Tank extends Terran {

	
	void move(int x, int y) {
		System.out.printf("좌표(%d, %d)길을 확인해서 이동합니다.(Tank는 길이있어야 이동이 가능합니다.), 이동속도 50\n",x,y);
	}
	
	void changeMode() {
		System.out.println("모드를 변경합니다.");
	}
	
}
