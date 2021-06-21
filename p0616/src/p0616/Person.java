package p0616;

public class Person {
	private long id;
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Person) {
			if( id == ((Person)obj).id) return true;
			else return false;
		}else {
			return false;
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
