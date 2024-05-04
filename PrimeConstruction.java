import java.util.Arrays;

public class PrimeConstruction {

    public static void main(String[] args) {
        int[] input = {3, 4, 5, 1};
        long result = findSmallestPrime(input);
        System.out.println(result);
    }

    private static long findSmallestPrime(int[] input) {
        Arrays.sort(input); // Sorting the input array to find the smallest natural number 'q'
        int q = input[0];

        // Start checking for the smallest prime number
        long p = q + 1;
        while (true) {
            boolean isValid = true;
            for (int num : input) {
                if (num != q && p % num != q) {
                    isValid = false;
                    break;
                }
            }
            if (isValid && isPrime(p)) {
                return p;
            }
            p++;
        }
    }

    private static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}