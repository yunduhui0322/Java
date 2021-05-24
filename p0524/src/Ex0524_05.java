
public class Ex0524_05 {
	public static void main(String[] args) {
		Deck d = new Deck();//52장 Card -> 1~13 , 1~4
//		d.c[0].card_print(1, 1);
		//0번부터 5번까지6장의 카드를 순서대로 출력
		d.shuffle();
//		for(int i=1; i<=1; i++) {
//			for(int j=1; j<=6; j++) {
//				d.c[13*(i-1)+(j-1)].card_print(d.c[13*(i-1)+(j-1)].kind, d.c[13*(i-1)+(j-1)].number);
//			}
//		}
		for(int i=1; i<=6; i++) {
			d.c[i].card_print(d.c[i].kind, d.c[i].number);
		}
	}//main
}//class
