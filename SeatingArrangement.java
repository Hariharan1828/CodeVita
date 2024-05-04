

import java.util.Scanner;

public class SeatingArrangement {

    static int comb(int n, int r) {
        return fact(n) / (fact(r) * fact(n - r));
    }

    static int fact(int n) {
        if (n <= 1) return 1;
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        int ans = comb(n, r);
        System.out.print(ans);

        sc.close();
    }
}