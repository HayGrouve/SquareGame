public class Square {
	private boolean state = false;
	private int count = 0;

	public Square(int state) {
		if (state == 0) {
			this.state = false;
		} else if (state == 1) {
			this.state = true;
		} else {
			throw new IllegalArgumentException("State needs to be 0 or 1");
		}
	}
	public Square(boolean state, int count) {
		this.state = state;
		this.count = count;
	}

	public void changeColour() {
		if (state == false) {
			state = true;
			count++;
		} else {
			state = false;
		}
	}

	public int getCount() {
		return count;
	}

	public boolean getState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
