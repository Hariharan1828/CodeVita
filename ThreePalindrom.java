import java.util.Scanner;

public class ThreePalindrom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        String[] result = findThreePalindromes(word);

        if (result == null) {
            System.out.println("Impossible");
        } else {
            for (String palindrome : result) {
                System.out.println(palindrome);
            }
        }
    }

    private static String[] findThreePalindromes(String word) {
        int len = word.length();

        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String first = word.substring(0, i);
                String second = word.substring(i, j);
                String third = word.substring(j);

                if (isPalindrome(first) && isPalindrome(second) && isPalindrome(third)) {
                    return new String[]{first, second, third};
                }
            }
        }

        return null;
    }

    private static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}