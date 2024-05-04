import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Project {
    int expenditure;
    int bonus;
    int penalty;

    Project(int expenditure, int bonus, int penalty) {
        this.expenditure = expenditure;
        this.bonus = bonus;
        this.penalty = penalty;
    }
}

public class Project10 {
    public static int findMinBudget(int n, Project[] projects) {
        Arrays.sort(projects, Comparator.comparingInt(project -> project.bonus - project.penalty));
        int budget = 0;

        for (Project project : projects) {
            int requiredBudget = project.expenditure + project.bonus;
            budget = Math.max(budget, requiredBudget);

            if (budget - project.penalty < 0) {
                budget = project.penalty;
            }
        }

        return budget;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Project[] projects = new Project[n];

        for (int i = 0; i < n; i++) {
            int expenditure = scanner.nextInt();
            int bonus = scanner.nextInt();
            int penalty = scanner.nextInt();
            projects[i] = new Project(expenditure, bonus, penalty);
        }

        int result = findMinBudget(n, projects);
        System.out.println(result);
    }
}
