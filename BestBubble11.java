import java.util.*;

public class BestBubble11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] originalArray = new int[n];
        int[] ascendingArray = new int[n];

        for (int i = 0; i < n; i++) {
            originalArray[i] = scanner.nextInt();
            ascendingArray[i] = originalArray[i];
        }

        System.out.print(Math.min(bubbleSort(ascendingArray, n, true), bubbleSort(originalArray, n, false)));

        scanner.close();
    }

    static int bubbleSort(int[] arr, int n, boolean ascending) {
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean swapCondition = ascending ? arr[j] > arr[j + 1] : arr[j] < arr[j + 1];

                if (swapCondition) {
                    swapCount++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return swapCount;
    }
}
