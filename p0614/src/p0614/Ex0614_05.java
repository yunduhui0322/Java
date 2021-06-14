package p0614;

public class Ex0614_05 {
	public static void main(String[] args) {
		
		PlayIngCard pc = new PlayingCardImpl();
		
		String str = pc.getCardKind();
		System.out.println("카드종류 : " + str);
	}
}
