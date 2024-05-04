import java.util.Scanner;

public class MilksAndbottles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int demand = scanner.nextInt();

            int minBottles = calculateMinBottles(demand);

            System.out.println(minBottles);
        }
    }

    private static int calculateMinBottles(int demand) {
        int[] bottleSizes = {10, 7, 5, 1};
        int minBottles = 0;

        for (int size : bottleSizes) {
            minBottles += demand / size;
            demand %= size;
        }

        return minBottles;
    }
}
