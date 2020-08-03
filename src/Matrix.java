public class Matrix {
	// 2 dimensional arrays that will contain objects of type Square
	private Square[][] matrix;
	private Square[][] temp;
	
//	Possible positions that a square can be in the 2D array
	
//	position1,position2,position3
//	position8,position9,position4
//	position7,position6,position5
	

	/**
	 * Constructor, initializes the arrays and fills them with Squares, with values
	 * given by the user
	 * 
	 * @param x      Width of the 2D array
	 * @param y      Height of the 2D array
	 * @param values String containing the first generation of colours
	 */
	public Matrix(int x, int y, String values) {
		this.matrix = new Square[x][y];
		this.temp = new Square[x][y];

		int size = values.length();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = Character.getNumericValue(values.charAt(i));
		}
		int counter = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				matrix[i][j] = new Square(arr[counter]);
				temp[i][j] = new Square(arr[counter]);
				counter++;
			}
		}

	}

	/*
	 * Copy the changes from main matrix
	 */
	public void copyMatrix(int x, int y) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i][j].setState(matrix[i][j].getState());
				temp[i][j].setCount(matrix[i][j].getCount());
			}
		}
	}

	/*
	 * Print the array
	 */
	public void print(int x, int y) {
		String str = "";
		System.out.println("Matrix: ");
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				str = (matrix[i][j].getState()) ? " | " : "| ";
				System.out.print(" | " + matrix[i][j].getState() + str);
			}
			System.out.println();
		}
	}

	/**
	 * Calculates each generation of colour changes
	 * 
	 * @param cellX       X coordinates for the cell we are looking for
	 * @param cellY       Y coordinates for the cell we are looking for
	 * @param x           Width of 2D array
	 * @param y           Height of 2D array
	 * @param generations Number of generations
	 * @return It returns how many times a cell has changed to green or was green
	 *         for one generation
	 */
	public int playGame(int cellX, int cellY, int x, int y, int generations) {
		// Loop through all generations
		for (int g = 0; g < generations; g++) {
			// Both 2D arrays start the same
			if (g > 0) {
				// Copy the results from last generation
				copyMatrix(x, y);
			}
			// Loop through each Square in the 2D array
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					int counter = 0;
					if (i == 0) {
						if (j == 0) { // if the Square is in upper-left most position in the array
//							position1
							if (this.temp[i][j + 1].getState()) {
								counter++;
							}
							if (this.temp[i + 1][j].getState()) {
								counter++;
							}
							if (this.temp[i + 1][j + 1].getState()) {
								counter++;
							}
							if (this.temp[i][j].getState()) { // if its green
								if (!(counter == 2 || counter == 3)) {
									this.matrix[i][j].changeColour();
								} else { // if it green and it will stay green
									this.matrix[i][j].setCount(this.matrix[i][j].getCount() + 1);
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						} else if (j == x - 1) { // if the Square is in upper-right most position in the array
//							position3
							if (this.temp[i + 1][j].getState()) {
								counter++;
							}
							if (this.temp[i + 1][j - 1].getState()) {
								counter++;
							}
							if (this.temp[i][j - 1].getState()) {
								counter++;
							}
							if (this.temp[i][j].getState()) { // if its green
								if (!(counter == 2 || counter == 3)) {
									this.matrix[i][j].changeColour();
								} else { // if it green and it will stay green
									this.matrix[i][j].setCount(this.matrix[i][j].getCount() + 1);
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						} else { // if the Square is in upper edge position in the array
//							position2
							if (this.temp[i][j - 1].getState()) {
								counter++;
							}
							if (this.temp[i][j + 1].getState()) {
								counter++;
							}
							if (this.temp[i + 1][j].getState()) {
								counter++;
							}
							if (this.temp[i + 1][j - 1].getState()) {
								counter++;
							}
							if (this.temp[i + 1][j + 1].getState()) {
								counter++;
							}
							if (this.temp[i][j].getState()) { // if its green
								if (!(counter == 2 || counter == 3)) {
									this.matrix[i][j].changeColour();
								} else { // if it green and it will stay green
									this.matrix[i][j].setCount(this.matrix[i][j].getCount() + 1);
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						}
					} else if (i == y - 1) { // if the Square is in lower-left most position in the array
						if (j == 0) {
//							position7
							if (this.temp[i - 1][j].getState()) {
								counter++;
							}
							if (this.temp[i][j + 1].getState()) {
								counter++;
							}
							if (this.temp[i - 1][j + 1].getState()) {
								counter++;
							}
							if (this.temp[i][j].getState()) { // if its green
								if (!(counter == 2 || counter == 3)) {
									this.matrix[i][j].changeColour();
								} else { // if it green and it will stay green
									this.matrix[i][j].setCount(this.matrix[i][j].getCount() + 1);
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						} else if (j == x - 1) { // if the Square is in lower-right most position in the array
//							position5
							if (this.temp[i - 1][j].getState()) {
								counter++;
							}
							if (this.temp[i - 1][j - 1].getState()) {
								counter++;
							}
							if (this.temp[i][j - 1].getState()) {
								counter++;
							}
							if (this.temp[i][j].getState()) { // if its green
								if (!(counter == 2 || counter == 3)) {
									this.matrix[i][j].changeColour();
								} else { // if it green and it will stay green
									this.matrix[i][j].setCount(this.matrix[i][j].getCount() + 1);
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						} else { // if the Square is in lower edge position in the array
//							position6
							if (this.temp[i][j - 1].getState()) {
								counter++;
							}
							if (this.temp[i - 1][j - 1].getState()) {
								counter++;
							}
							if (this.temp[i - 1][j].getState()) {
								counter++;
							}
							if (this.temp[i - 1][j + 1].getState()) {
								counter++;
							}
							if (this.temp[i][j + 1].getState()) {
								counter++;
							}
							if (this.temp[i][j].getState()) { // if its green
								if (!(counter == 2 || counter == 3)) {
									this.matrix[i][j].changeColour();
								} else { // if it green and it will stay green
									this.matrix[i][j].setCount(this.matrix[i][j].getCount() + 1);
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						}
					} else {
						if (j == 0) { // if the Square is on the left edge in the array
//							position8
							if (this.temp[i - 1][j].getState()) {
								counter++;
							}
							if (this.temp[i - 1][j + 1].getState()) {
								counter++;
							}
							if (this.temp[i][j + 1].getState()) {
								counter++;
							}
							if (this.temp[i + 1][j + 1].getState()) {
								counter++;
							}
							if (this.temp[i + 1][j].getState()) {
								counter++;
							}
							if (this.temp[i][j].getState()) { // if its green
								if (!(counter == 2 || counter == 3)) {
									this.matrix[i][j].changeColour();
								} else { // if it green and it will stay green
									this.matrix[i][j].setCount(this.matrix[i][j].getCount() + 1);
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						} else if (j == x - 1) { // if the Square is on right edge in the array
//							position4
							if (this.temp[i - 1][j].getState()) {
								counter++;
							}
							if (this.temp[i - 1][j - 1].getState()) {
								counter++;
							}
							if (this.temp[i][j - 1].getState()) {
								counter++;
							}
							if (this.temp[i + 1][j - 1].getState()) {
								counter++;
							}
							if (this.temp[i + 1][j].getState()) {
								counter++;
							}
							if (this.temp[i][j].getState()) { // if its green
								if (!(counter == 2 || counter == 3)) {
									this.matrix[i][j].changeColour();
								} else { // if it green and it will stay green
									this.matrix[i][j].setCount(this.matrix[i][j].getCount() + 1);
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						} else { // if the Square is in a central position in the array
//							position9
							if (this.temp[i - 1][j].getState()) {
								counter++;
							}
							if (this.temp[i - 1][j + 1].getState()) {
								counter++;
							}
							if (this.temp[i][j + 1].getState()) {
								counter++;
							}
							if (this.temp[i + 1][j + 1].getState()) {
								counter++;
							}
							if (this.temp[i + 1][j].getState()) {
								counter++;
							}
							if (this.temp[i + 1][j - 1].getState()) {
								counter++;
							}
							if (this.temp[i][j - 1].getState()) {
								counter++;
							}
							if (this.temp[i - 1][j - 1].getState()) {
								counter++;
							}
							if (this.temp[i][j].getState()) { // if its green
								if (!(counter == 2 || counter == 3 || counter == 6)) {
									this.matrix[i][j].changeColour();
								} else { // if it green and it will stay green
									this.matrix[i][j].setCount(this.matrix[i][j].getCount() + 1);
								}
							} else { // if its red
								if (counter == 3 || counter == 6) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						}
					}
				}
			}

		}
		return matrix[cellY][cellX].getCount();
	}
}
