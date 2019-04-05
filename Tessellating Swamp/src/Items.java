
public abstract class Items {
	
	private int[] location = new int[2];
	
	public int[] getLocation() {
		return location;
	}
	
	public Items(int x, int y) {
		location[0]=x;
		location[1]=y;
	}
	
	public abstract void move(String direction);
	
	public void setLocation(int x, int y) {
		location[0]=x;
		location[1]=y;
	}
}

