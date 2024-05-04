import java.util.*;

class Team {
    String name;
    int points;
    int goalDifference;
    int goalsFor;

    public Team(String name) {
        this.name = name;
        this.points = 0;
        this.goalDifference = 0;
        this.goalsFor = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void updateStats(int scored, int conceded) {
        goalsFor += scored;
        goalDifference += (scored - conceded);

        if (scored > conceded) {
            points += 2; // Win
        } else if (scored == conceded) {
            points += 1; // Draw
        }
    }
}

public class  Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Read input
        int numTeams = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        String[] teamNames = scanner.nextLine().split("\\s");
        int numMatches = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Step 2: Create teams and populate the HashMap
        Map<String, Team> teamMap = new HashMap<>();
        for (String teamName : teamNames) {
            teamMap.put(teamName, new Team(teamName));
        }

        // Step 3: Parse match information and update team stats
        for (int i = 0; i < numMatches; i++) {
            String team1 = scanner.next();
            String team2 = scanner.next();
            int score1 = scanner.nextInt();
            int score2 = scanner.nextInt();

            Team t1 = teamMap.get(team1);
            Team t2 = teamMap.get(team2);

            if (t1 == null || t2 == null || team1.equals(team2)) {
                System.out.println("Invalid Input");
                return;
            }

            t1.updateStats(score1, score2);
            t2.updateStats(score2, score1);
        }

        // Step 4: Sort teams based on ranking criteria
        List<Team> teamList = new ArrayList<>(teamMap.values());
        teamList.sort(Comparator
                .comparing(Team::getPoints).reversed()
                .thenComparing(Team::getGoalDifference).reversed()
                .thenComparing(Team::getGoalsFor).reversed()
                .thenComparing(Team::getName, String.CASE_INSENSITIVE_ORDER));

        // Step 5: Print the sorted list of team names
        for (Team team : teamList) {
            System.out.println(team.getName());
        }
    }
}
