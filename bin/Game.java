import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		Scanner scStr = new Scanner(System.in);

		System.out.println("Enter size(x, y): ");
		String size = scStr.nextLine();

		String[] integerSize = size.split(", ");
		int[] integers = new int[integerSize.length];
		for (int i = 0; i < integers.length; i++) {
			integers[i] = Integer.parseInt(integerSize[i]);
		}

		String values = "";
		for (int i = 0; i < integers[0]; i++) {
			System.out.println("Enter values for row: " + (i + 1));
			String row = scStr.next();
			values += row;
		}
		scStr.nextLine();
		System.out.println("Enter coordinates and number of generations(x, y, N): ");
		String condition = scStr.nextLine();

		String[] integerStrings = condition.split(", ");
		int[] integersXY = new int[integerStrings.length];
		for (int i = 0; i < integersXY.length; i++) {
			integersXY[i] = Integer.parseInt(integerStrings[i]);
		}

		System.out.println("Width is: " + integers[0]);
		System.out.println("Height is: " + integers[1]);
		Matrix matrix = new Matrix(integers[0], integers[1], values);
		System.out.println("Condition X: " + integersXY[0]);
		System.out.println("Condition Y: " + integersXY[1]);
		System.out.println("Condition N: " + integersXY[2]);
		matrix.print(integers[0], integers[1]);
		int result = matrix.playGame(integersXY[0], integersXY[1], integers[0], integers[1], integersXY[2]);
		System.out.println("Result is: " + result);
		matrix.print(integers[0], integers[1]);
		scStr.close();
	}
}
