package p0614_002;

public class Medic extends GroundUnit implements heal{

	Medic() {
		super(50);
		hitPoint = MAX_HP;
	}
	
	void healing(heal h) {
		Unit u = (Unit) h;
		while(u.hitPoint != u.MAX_HP) {
			u.hitPoint++;
			
		}
		if(u.hitPoint == u.MAX_HP) {
			System.out.printf("체력: %d\n치료가 완료되었습니다\n",u.hitPoint);
		}
	}

}
