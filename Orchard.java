import java.util.Scanner;

public class Orchard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        String ashokRow = sc.next();
        String anandRow = sc.next();

        // Output
        String result = findWinner(ashokRow, anandRow);
        System.out.println(result);

        sc.close();
    }

    static int countPossibilities(String row) {
        int count = 0;
        for (int i = 0; i < row.length() - 2; i++) {
            if (row.charAt(i) != row.charAt(i + 1) || row.charAt(i) != row.charAt(i + 2) || row.charAt(i + 1) != row.charAt(i + 2)) {
                count++;
            }
        }
        return count;
    }

    static String findWinner(String ashokRow, String anandRow) {
        int ashokPossibilities = countPossibilities(ashokRow);
        int anandPossibilities = countPossibilities(anandRow);

        if (ashokPossibilities > anandPossibilities) {
            return "Ashok";
        } else if (anandPossibilities > ashokPossibilities) {
            return "Anand";
        } else {
            return "Draw";
        }
    }
}
