

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Determinants {

	// This will work for N*N Matrix
	public static void main(String[] args) {
		int arr[][] = new int[][] { { 2, 3, 4, 6, 1, 1 }, { 4, 5, 2, 3, 1, 2 }, { 6, 3, 5, 1, 3, 4 },
				{ 2, 4, 6, 2, 2, 3 }, { 1, 1, 2, 3, 4, 1 }, { 2, 3, 3, 3, 1, 1 } };
		System.out.println("Determinant is " + determinant(arr));
	}

	static int determinant(int arr[][]) {
		if (arr.length == 2) {
			return arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];

		} else {
			int temp = 0, sign = 1, val = 0;
			for (int i = 0; i < arr.length; i++) {
				temp = arr[0][i] * determinant(makeArray(arr, 0, i));
				val = val + sign * temp;
				sign = sign * -1;

			}

			return val;
		}
	}

	static int[][] makeArray(int mainArray[][], int exrow, int excol) {
		int dim = mainArray[0].length - 1;
		int arrayToReturn[][] = new int[dim][dim];

		int row = 0, col = 0;
		for (int x = 0; x < mainArray.length; x++)
			for (int y = 0; y < mainArray[0].length; y++) {
				if (x == exrow || y == excol)
					continue;
				else {
					if (x - 1 < 0)
						row = x;
					else
						row = x - 1;
					if (y - 1 < 0)
						col = y;
					else
						col = y - 1;

					if (y < excol && y != 0) {
						col++;
					}
					arrayToReturn[row][col] = mainArray[x][y];

				}
			}
		return arrayToReturn;

	}

}
