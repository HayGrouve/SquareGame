import java.util.Arrays;

public class Matrix {
	private Square[][] matrix;
	private Square[][] temp;

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

	public void copyMatrix(int x, int y) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i][j].setState(matrix[i][j].getState());
				temp[i][j].setCount(matrix[i][j].getCount());
			}
		}
	}

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

	public int playGame(int cellX, int cellY, int x, int y, int generations) {
		for (int g = 0; g < generations; g++) {
			if (g > 0) {
				copyMatrix(x, y);
			}
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					int counter = 0;
					if (i == 0) {
						if (j == 0) {
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
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						} else if (j == y - 1) {
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
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						} else {
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
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						}
					} else if (i == x - 1) {
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
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						} else if (j == y - 1) {
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
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						} else {
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
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						}
					} else {
						if (j == 0) {
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
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						} else if (j == y - 1) {
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
							if (this.temp[i - 1][j - 1].getState()) {
								counter++;
							}
							if (this.temp[i - 1][j].getState()) {
								counter++;
							}
							if (this.temp[i][j].getState()) { // if its green
								if (!(counter == 2 || counter == 3)) {
									this.matrix[i][j].changeColour();
								}
							} else { // if its red
								if (counter == 3) {
									this.matrix[i][j].changeColour();
								}
							}
							continue;
						} else {
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
