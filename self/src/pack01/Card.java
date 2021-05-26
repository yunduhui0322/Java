package pack01;

public class Card {
	private int number;
	private int kind;
	
	Card(){
		this(1,1);
	}
	Card(int kind,int number ){
		this.number = number;
		this.kind = kind;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
}
