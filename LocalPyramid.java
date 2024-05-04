import java.util.Scanner;
import java.util.ArrayList;

public class LocalPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        ArrayList<Integer> series = new ArrayList<>();
        ArrayList<Integer> pyramidNumbers = new ArrayList<>();
        int index = 0;

        for (int i = 3; i <= 500; i++) {
            series.add((i * (i + 1)) / 2);
        }

        for (int j = 0; j < 497; j += 4) {
            pyramidNumbers.add(series.get(j));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(String.format("%05d", pyramidNumbers.get(index)) + " ");
                index++;
            }
            if (i == N - 1) {
                break;
            }
            System.out.println();
        }
    }
}
