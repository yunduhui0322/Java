package p0614;

public class DropShip extends Terran {
	
	
	void move(int x, int y) {
		System.out.printf("좌표(%d, %d)직선으로 이동(길이 없어도 이동합니다.), 이동속도 80\n",x,y);
	}
	
	void load() {
		System.out.println("사람 8명 또는 탱크 2대를 태웁니다.");
	}
	
	void unload() {
		System.out.println("태운 대상을 내립니다.");
	}
}
