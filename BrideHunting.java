import java.util.Scanner;

public class BrideHunting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row");
        int r = sc.nextInt();  // Read the number of rows
        System.out.println("Enter the col");
        int c = sc.nextInt();  // Read the number of columns
        int fc = -1;           // bride with max no of qualities
        int fr = 1;            // position of the best bride
        int fc1 = 1;           // position of the best bride
        int[][] a = new int[r][c];
        int i;
        int j;

        // Read the matrix values from the user
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                if (a[i][j] == 1) {  // bride exists
                    int cnt = 0;      // no of qualities

                    // Check neighboring positions for qualities
                    if (j + 1 < c && a[i][j + 1] == 1)  // same row right
                        cnt++;
                    if (j - 1 >= 0 && a[i][j - 1] == 1)  // same row left
                        cnt++;
                    if (i + 1 < r) {
                        if (a[i + 1][j] == 1)             // bottom row
                            cnt++;
                        if (j + 1 < c && a[i + 1][j + 1] == 1)  // bottom row right
                            cnt++;
                        if (j - 1 >= 0 && a[i + 1][j - 1] == 1)  // bottom row left
                            cnt++;
                    }
                    if (i - 1 >= 0) {
                        if (a[i - 1][j] == 1)             // top row
                            cnt++;
                        if (j + 1 < c && a[i - 1][j + 1] == 1)  // top row right
                            cnt++;
                        if (j - 1 >= 0 && a[i - 1][j - 1] == 1)  // top row left
                            cnt++;
                    }

                    // If bride has most qualities
                    if (cnt > fc) {
                        fc = cnt;
                        fr = i;
                        fc1 = j;
                    } else if (cnt == fc) {  // If bride has equal no of qualities compared to the best bride
                        // Check for a bride with a shorter distance
                        if (Math.abs(fr - 1 + fc1 - 1) > Math.abs(i - 1 + j - 1)) {
                            fr = i;
                            fc1 = j;
                        }
                    }
                }
            }
        }

        // Print the result in the format: row:column:qualities
        System.out.println((fr + 1) + ":" + (fc1 + 1) + ":" + fc);
    }
}