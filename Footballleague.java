import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class FootballLeague {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Consume the newline character
        sc.nextLine();

        String[] teamname = new String[n];
        for (int i = 0; i < n; i++) {
            teamname[i] = sc.nextLine();
        }

        int matchesNo = sc.nextInt();
        String[][] matches = new String[matchesNo][4];
        for (int i = 0; i < matchesNo; i++) {
            for (int j = 0; j < 4; j++) {
                matches[i][j] = sc.nextLine();
            }
        }

        int x = 0;
        HashMap<String, Integer> mp = new HashMap<>();

        while (x++ < matchesNo) {
            for (int i = 0; i < 4; i++) {
                int g1 = Integer.parseInt(matches[x][2]);
                int g2 = Integer.parseInt(matches[x][3]);

                if (g1 > g2) {
                    if (mp.containsKey(matches[x][0])) {
                        mp.put(matches[x][0], mp.getOrDefault(matches[x][0], 0) + 2);
                    }
                    mp.put(matches[x][0], 2);
                } else if (g2 > g1) {
                    if (mp.containsKey(matches[x][1])) {
                        mp.put(matches[x][1], mp.getOrDefault(matches[x][0], 0) + 2);
                    }
                    mp.put(matches[x][1], 2);
                } else {
                    if (mp.containsKey(matches[x][1])) {
                        mp.put(matches[x][1], mp.getOrDefault(matches[x][0], 0) + 0);
                    }
                    mp.put(matches[x][1], 0);
                    if (mp.containsKey(matches[x][0])) {
                        mp.put(matches[x][0], mp.getOrDefault(matches[x][0], 0) + 0);
                    }
                    mp.put(matches[x][0], 0);
                }
            }

            mp.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        }
    }
}