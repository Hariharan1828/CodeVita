import java.util.Scanner;

public class Skateboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Read the size of the grid (N)
        int N = scanner.nextInt();
        scanner.nextLine(); // Move to the next line

        // Step 2: Create a 2D array to represent the grid
        String[][] grid = new String[N][N];

        // Step 3: Populate the grid based on the input
        for (int row = 0; row < N; row++) {
            String line = scanner.nextLine();
            String[] elements = line.split(",");

            for (int col = 0; col < N; col++) {
                grid[row][col] = elements[col];
            }
        }

        // Step 4: Calculate the number of safe starting points on the North or West border
        int safeStartingPoints = calculateSafeStartingPoints(N, grid);

        // Step 5: Output the result
        System.out.println(safeStartingPoints);

        // Step 6: Close the scanner
        scanner.close();
    }

    // Function to calculate the number of safe starting points
    private static int calculateSafeStartingPoints(int N, String[][] grid) {
        int count = 0;

        // Check the North border
        for (int col = 0; col < N; col++) {
            if (canReachFinalDestination(0, col, N, grid)) {
                count++;
            }
        }

        // Check the West border
        for (int row = 1; row < N; row++) {
            if (canReachFinalDestination(row, 0, N, grid)) {
                count++;
            }
        }

        return count;
    }

    // Function to check if a starting point can reach the final destination
    private static boolean canReachFinalDestination(int row, int col, int N, String[][] grid) {
        // Check if the current square is not a Drop square
        if (grid[row][col].equals("D")) {
            return false;
        }

        // Check if there is at least one valid direction that leads to the final destination
        if (grid[row][col].equals("F")) {
            return true;
        }

        // Iterate through each direction in the cell
        for (char direction : grid[row][col].toCharArray()) {
            switch (direction) {
                case 'N':
                    if (row > 0 && canReachFinalDestination(row - 1, col, N, grid)) {
                        return true;
                    }
                    break;
                case 'E':
                    if (col < N - 1 && canReachFinalDestination(row, col + 1, N, grid)) {
                        return true;
                    }
                    break;
                case 'S':
                    if (row < N - 1 && canReachFinalDestination(row + 1, col, N, grid)) {
                        return true;
                    }
                    break;
                case 'W':
                    if (col > 0 && canReachFinalDestination(row, col - 1, N, grid)) {
                        return true;
                    }
                    break;
            }
        }

        // If no valid path found
        return false;
    }
}
