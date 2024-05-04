import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chakravuha1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] matrix = new int[N][N];
        int num = 1, powerPoints = 1;
        List<String> powerPointCoordinates = new ArrayList<>();
        powerPointCoordinates.add("(0,0)");

        int top = 0, bottom = N - 1, left = 0, right = N - 1;

        while (num <= N * N) {
            // Traverse top row
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
                if (num % 11 == 1) {
                    powerPoints++;
                    powerPointCoordinates.add("(" + top + "," + i + ")");
                }
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
                if (num % 11 == 1) {
                    powerPoints++;
                    powerPointCoordinates.add("(" + i + "," + right + ")");
                }
            }
            right--;

            // Traverse bottom row
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
                if (num % 11 == 1) {
                    powerPoints++;
                    powerPointCoordinates.add("(" + bottom + "," + i + ")");
                }
            }
            bottom--;

            // Traverse left column
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
                if (num % 11 == 1) {
                    powerPoints++;
                    powerPointCoordinates.add("(" + i + "," + left + ")");
                }
            }
            left++;
        }

        printMatrix(matrix);
        System.out.println("\nTotal Power points: " + powerPoints);
        for (String coordinate : powerPointCoordinates) {
            System.out.println(coordinate);
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}