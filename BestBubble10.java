import java.util.Arrays;
import java.util.Scanner;

public class BestBubble10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Set the sentinel value for termination
        int sentinelValue = -1;

        // Read the number of elements (n)
        System.out.print("Enter the number of elements (n): ");
        int n = sc.nextInt();

        // Validate the input
        while (n <= 0) {
            System.out.println("Invalid input. Please enter a positive integer for n: ");
            n = sc.nextInt();
        }

        // Initialize the array
        int[] arr = new int[n];

        // Read the array elements until the sentinel value is entered
        int i = 0;
        while (i < n) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int inputValue = sc.nextInt();

            // Check for sentinel value to terminate input
            if (inputValue == sentinelValue) {
                break;
            }

            arr[i] = inputValue;
            i++;
        }

        // Sort the array and determine the minimum swaps
        int ascSwaps = minSwapsToSort(arr.clone(), n, true);
        int descSwaps = minSwapsToSort(arr.clone(), n, false);

        // Print the minimum number of swaps
        System.out.print("Minimum number of swaps: " + Math.min(ascSwaps, descSwaps));

        sc.close();
    }

    // Function to calculate minimum swaps for sorting
    static int minSwapsToSort(int[] arr, int n, boolean ascending) {
        int swaps = 0;

        while (!isSorted(arr, ascending)) {
            if (ascending) {
                int minIndex = findMinIndex(arr);
                for (int i = minIndex; i > 0; i--) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    swaps++;
                }
            } else {
                int maxIndex = findMaxIndex(arr);
                for (int i = maxIndex; i < n - 1; i++) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swaps++;
                }
            }
        }

        return swaps;
    }

    // Function to check if the array is sorted
    static boolean isSorted(int[] arr, boolean ascending) {
        int n = arr.length;
        if (ascending) {
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Function to find the minimum index
    static int findMinIndex(int[] arr) {
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    // Function to find the maximum index
    static int findMaxIndex(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
