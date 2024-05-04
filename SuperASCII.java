import java.util.Scanner;

public class SuperASCII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();

        checkSuperASCII(s);

        scanner.close();
    }

    private static void checkSuperASCII(String s) {
        int[] b = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            b[index]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            if (b[index] != index + 1) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
