import java.util.*;

public class StringFromRankPermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rank = scanner.nextInt();
        int length = scanner.nextInt();
        length -= 1;
        String result = stringFromRank(rank, length);
        System.out.println(result);
    }

    private static String stringFromRank(int rank, int length) {
        StringBuilder result = new StringBuilder();
        ArrayList<Character> characters = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++) {
            characters.add(c);
        }

        rank--;

        generatePermutations(characters, length, rank, result);
        return result.toString();
    }

    private static void generatePermutations(ArrayList<Character> characters, int length, int rank, StringBuilder result) {
        if (length == 0) {
            result.append(characters.get(rank));
            return;
        }

        int factorial = factorial(length - 1);

        int index = rank / factorial;
        if (index >= characters.size()) {
            index = characters.size() - 1;
        }

        result.append(characters.get(index));

        // Adjust the rank for the next iteration
        rank %= factorial;

        characters.remove(index);

        generatePermutations(characters, length - 1, rank, result);
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
