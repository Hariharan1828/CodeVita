import java.util.Scanner;

public class GamesOfPrimes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowerLimit = scanner.nextInt();
        int upperLimit = scanner.nextInt();
        int nthNumber = scanner.nextInt();

        // Initialize an array to store the combined numbers within the range
        int[] combinedNumbers = new int[upperLimit - lowerLimit + 1];

        // Initialize a counter to keep track of the number of combined numbers found
        int combinedNumberCount = 0;

        // Generate the combined numbers within the range
        for (int number = lowerLimit; number <= upperLimit; number++) {
            int gameNumber = calculateGameNumber(number);

            // Check if the game number is prime
            if (isPrime(gameNumber)) {
                combinedNumbers[combinedNumberCount++] = number;

                // Check if the required number of combined numbers has been found
                if (combinedNumberCount == nthNumber) {
                    break;
                }
            }
        }

        // Print the Nth combined number
        System.out.println(combinedNumbers[nthNumber - 1]);

        scanner.close();
    }

    private static int calculateGameNumber(int number) {
        int gameNumber = number;

        while (gameNumber % 10 != 1) {
            int sumOfSquares = 0;

            while (number > 0) {
                int digit = number % 10;
                sumOfSquares += digit * digit;
                number /= 10;
            }

            gameNumber = sumOfSquares;
        }

        return gameNumber;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}
