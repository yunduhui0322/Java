package p0614;

public class Marine extends Terran {

	void move(int x, int y) {
		System.out.printf("좌표:(%d, %d)길을 확인해서이동. (Marine은 길이 있어야 이동할 수 있습니다.), 이동속도 10\n",x,y);
	}
	
	
	void stimPack() {
		System.out.println("스팀팩 주사를 복용합니다.");
	}
	
}
