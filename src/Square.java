public class Square {
	private boolean state = false;
	private int count = 0;

	/**
	 * Constructor initialises a square
	 * 
	 * @param state it can be 1 or 0
	 */
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

//Changes the colour of a square when called
	public void changeColour() {
		if (state == false) {
			state = true;
			count++;
		} else {
			state = false;
		}
	}

//Accessors and mutators
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
