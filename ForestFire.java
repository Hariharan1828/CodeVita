//https://code.letuscrack.com/forest-fire-tcs-codevita/
import java.util.Scanner;

public class ForestFire {
    static int m, n, c = 0;
    static int[][] t;

    static boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    static void fCount(int r, int s) {
        if (!isValid(r, s) || t[r][s] != 1) {
            return;
        }

        t[r][s] = -1;

        int[] ap = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] bp = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = r + ap[i];
            int newCol = s + bp[i];

            if (isValid(newRow, newCol) && t[newRow][newCol] == 1) {
                fCount(newRow, newCol);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        t = new int[m][n];

        int x = sc.nextInt();
        int y = sc.nextInt();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (t[i][j] == 1) {
                    fCount(i, j);
                    c++;
                }
            }
        }

        System.out.println(c);
    }
}