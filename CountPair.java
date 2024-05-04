import java.util.*;

public class CountPair {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int b = sc.nextInt();
            a.add(b);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int r1 = a.get(i) - k;
            int r2 = a.get(i) + k;
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (j != i && a.get(j) >= r1 && a.get(j) <= r2) {
                    count++;
                }
            }
            if (count >= 1) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}