import java.util.Scanner;

public class SortingBoxes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        int heaviestIndex = findHeaviestIndex(weights);
        swap(weights, heaviestIndex, k);

        // Sorting is the last step
        sortRemainingParcels(weights, k);

        int totalEffort = calculateTotalEffort(weights);
        System.out.println(totalEffort);
    }

    private static int findHeaviestIndex(int[] weights) {
        int heaviestIndex = 0;
        for (int i = 1; i < weights.length; i++) {
            if (weights[i] > weights[heaviestIndex]) {
                heaviestIndex = i;
            }
        }
        return heaviestIndex;
    }

    private static void swap(int[] weights, int i, int j) {
        int temp = weights[i];
        weights[i] = weights[j];
        weights[j] = temp;
    }

    private static void sortRemainingParcels(int[] weights, int k) {
        for (int i = k + 1; i < weights.length; i++) {
            for (int j = i; j > k; j--) {
                if (weights[j] < weights[j - 1]) {
                    swap(weights, j, j - 1);
                }
            }
        }
    }

    private static int calculateTotalEffort(int[] weights) {
        int totalEffort = 0;
        for (int i = 0; i < weights.length - 1; i++) {
            totalEffort += weights[i] * weights[i + 1];
        }
        return totalEffort;
    }
}
