import java.util.Arrays;
import java.util.Scanner;

public class JumbleWithNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T1 = scanner.nextInt();
        int T2 = scanner.nextInt();
        int M = scanner.nextInt();
        int[] l = new int[10];
        int count = 0;
        for (int i = 1; i <= T2; i++) {

            int logic = i * (2 * i - 1);
            if (logic <= T2 && logic >= T1) {
                l[i-1] = logic;
            }

        }
        System.out.println(l[M - 1]);

    }
    }




