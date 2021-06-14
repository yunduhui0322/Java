package p0614;

public class DvdPlayer extends Player {

	@Override
	void play(int point) {
		//1.영상코덱 읽어서, 영상이 나오도록 구현
		//2. 음성코덱 읽어서, 음성이 나오도록 구현
		System.out.println("영상코덱 읽어오기-->> 영상코덱 해독 -->> 영상파일 모니터 화면에 출력");
		System.out.println("음성코덱 읽어오기-->> 음성코덱 해독 -->> 음성파일 모니터 스피커로 출력");
	}

	@Override
	void stop() {

	}

}
