package p0614;

public abstract class Player {

	int playPoint;
	
	Player(){
		playPoint = 0;
	}
	
	
	abstract void play(int point);
	abstract void stop();
	
	void play() {
		play(playPoint);
	}
}
