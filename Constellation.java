import java.util.Scanner;

public class Constellation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] co = new char[3][n];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                co[i][j] = sc.next().charAt(0);
            }
        }

        for (int i = 0; i < n - 2; i++) {
            if (co[0][i] == '#') {
                System.out.print("#");
                continue;
            }
            if (co[0][i] == '.' && co[0][i + 1] == '*' && co[0][i + 2] == '.') {
                if (co[1][i] == '*' && co[1][i + 1] == '*' && co[1][i + 2] == '*'
                        && co[2][i] == '*' && co[2][i + 1] == '.' && co[2][i + 2] == '*') {
                    System.out.print("A");
                    i += 2;
                    continue;
                }
            }
            if (co[0][i] == '*' && co[0][i + 1] == '*' && co[0][i + 2] == '*') {
                if (co[1][i] == '*' && co[1][i + 1] == '*' && co[1][i + 2] == '*') {
                    if (co[2][i] == '*' && co[2][i + 1] == '*' && co[2][i + 2] == '*') {
                        System.out.print("E");
                        i += 2;
                        continue;
                    }
                } else if (co[1][i] == '.' && co[1][i + 1] == '*' && co[1][i + 2] == '.') {
                    if (co[2][i] == '*' && co[2][i + 1] == '*' && co[2][i + 2] == '*') {
                        System.out.print("I");
                        i += 2;
                        continue;
                    }
                } else if (co[1][i] == '*' && co[1][i + 1] == '.' && co[1][i + 2] == '*') {
                    if (co[2][i] == '*' && co[2][i + 1] == '*' && co[2][i + 2] == '*') {
                        System.out.print("O");
                        i += 2;
                        continue;
                    }
                }
            }
            if (co[0][i] == '*' && co[0][i + 1] == '.' && co[0][i + 2] == '*'
                    && co[1][i] == '*' && co[1][i + 1] == '.' && co[1][i + 2] == '*'
                    && co[2][i] == '*' && co[2][i + 1] == '*' && co[2][i + 2] == '*') {
                System.out.print("U");
                i += 2;
                continue;
            }
        }
    }
}
