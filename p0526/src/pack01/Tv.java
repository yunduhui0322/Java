package pack01;

public class Tv {
	boolean power;
	int channel;

	void power() {
		power = !power;
	};

	void channelUp() {
		channel++;
	};

	void channelDown() {
		channel--;
	};
//	void caption() {
//		System.out.println("Tv의 캡션 메소드");
//	}
}
