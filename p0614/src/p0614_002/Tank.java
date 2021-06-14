package p0614_002;

public class Tank extends GroundUnit implements Repairable{

	Tank() {
		super(150);//땡크 체력 150
	    hitPoint = MAX_HP;//Tank 생성시 현재 체력 : 150
	}
	

}
