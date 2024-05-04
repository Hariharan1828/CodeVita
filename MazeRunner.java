import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cell {
    int x, y, distance, obstacles;

    public Cell(int x, int y, int distance, int obstacles) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.obstacles = obstacles;
    }
}

public class MazeRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] maze = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        int startRow = sc.nextInt();
        int startCol = sc.nextInt();

        int targetRow = sc.nextInt();
        int targetCol = sc.nextInt();

        int result = shortestPath(maze, startRow, startCol, targetRow, targetCol);
        System.out.println(result);

        sc.close();
    }

    public static int shortestPath(int[][] maze, int startRow, int startCol, int targetRow, int targetCol) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(startRow, startCol, 0, 0));

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            if (current.x == targetRow && current.y == targetCol) {
                return current.distance;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = current.x + dx[i];
                int newCol = current.y + dy[i];

                if (isValid(newRow, newCol, maze.length, maze[0].length, maze)) {
                    int newObstacles = current.obstacles + maze[newRow][newCol];

                    if (newObstacles <= 2) {
                        queue.add(new Cell(newRow, newCol, current.distance + 1, newObstacles));
                        maze[newRow][newCol] = 3;
                    }
                }
            }
        }

        return -1;
    }

    public static boolean isValid(int row, int col, int numRows, int numCols, int[][] maze) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols && maze[row][col] != 1 && maze[row][col] != 3;
    }
}
