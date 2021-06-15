package p0615;

public class Scv extends GroundUnit implements Repairable {

	public Scv() {
		super(50);
	}

	
	void repair_unit(Repairable r) {
			Unit u = (Unit)r;
		while(u.MAX_HP != u.hitPoint) {
			u.hitPoint++;
			System.out.printf("%s 수리중입니다. 현재체력:%d\n",u.getClass().getSimpleName(),u.hitPoint);
		}
		System.out.printf("%s 수리가 완료되었습니다.현재체력 %d\n",u.getClass().getSimpleName(),u.hitPoint);
	}
}
