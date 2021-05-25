
public class Ex0524_05 {
	public static void main(String[] args) {
		Deck d = new Deck();//52장 Card -> 1~13 , 1~4
//		d.c[0].card_print(1, 1);
		//0번부터 5번까지6장의 카드를 순서대로 출력
		d.shuffle();
//		for(int i=1; i<=5; i++) {
//				d.card_print(d.c[i-1]);
//			}
		for(int i=1; i<=Card.kinds_num; i++) {
			for(int j=1; j<=Card.numbers_num; j++) {
				d.card_print(d.c[13*(i-1)+(j-1)]);
			}
		}//전체출력
//		for(int i=1; i<=6; i++) {
//			d.c[i].card_print(d.c[i].kind, d.c[i].number);
//		}
	}//main
}//class
