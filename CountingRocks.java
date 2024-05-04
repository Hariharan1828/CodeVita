import java.util.Scanner;

class CountingRocks {
    static int[] count(int[][] r, int[] s) {
        int n = r.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int cnt = 0;

            for (int size : s) {
                if (size >= r[i][0] && size <= r[i][1]) {
                    cnt++;
                }
            }

            ans[i] = cnt;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int[] samp = new int[s];
        for (int i = 0; i < s; i++) {
            samp[i] = sc.nextInt();
        }

        int n = sc.nextInt();
        int[][] range = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                range[i][j] = sc.nextInt();
            }
        }

        int[] ans = count(range, samp);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}