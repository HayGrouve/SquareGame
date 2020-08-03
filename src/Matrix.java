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

}
