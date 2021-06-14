package p0614_002;

public class Scv extends GroundUnit implements Repairable {

	public Scv() {
		super(45);
		hitPoint = MAX_HP;
	}

	void repair(Repairable r) {
		if(r instanceof Unit) {
			Unit u = (Unit) r;
			while(hitPoint != u.MAX_HP) {
				u.hitPoint++;
				if(u.hitPoint == u.MAX_HP) {
					System.out.printf("체력: %d\n수리가 완료되었습니다\n",u.hitPoint);
					return;
				}
			}
			
		}
	}
}
