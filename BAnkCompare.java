import java.util.Scanner;

public class BAnkCompare {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            double principal = sc.nextDouble();

            int tenure = sc.nextInt();

            int n1 = sc.nextInt();
            double[] ratesA = new double[n1];
            int[] periodsA = new int[n1];
            for (int i = 0; i < n1; i++) {
                periodsA[i] = sc.nextInt();
                ratesA[i] = sc.nextDouble();
            }

            int n2 = sc.nextInt();
            double[] ratesB = new double[n2];
            int[] periodsB = new int[n2];
            for (int i = 0; i < n2; i++) {
                periodsB[i] = sc.nextInt();
                ratesB[i] = sc.nextDouble();
            }

            double emiA = calculateEMI(principal, ratesA, periodsA, tenure);
            double emiB = calculateEMI(principal, ratesB, periodsB, tenure);

            if (emiA < emiB) {
                System.out.println("Bank A");
            } else {
                System.out.println("Bank B");
            }
        }
    }

    private static double calculateEMI(double principal, double[] rates, int[] periods, int tenure) {
        double minEMI = Double.MAX_VALUE;

        for (int i = 0; i < rates.length; i++) {
            double monthlyInterestRate = rates[i] / (12 * 100);
            int totalMonths = tenure * 12;
            int slabMonths = periods[i] * 12;

            double emi = principal * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -totalMonths));

            if (slabMonths == totalMonths) {
                minEMI = Math.min(minEMI, emi);
            } else {
                double remainingEMI = calculateEMI(principal, rates, periods, tenure - periods[i]);
                minEMI = Math.min(minEMI, Math.max(emi, remainingEMI));
            }
        }

        return minEMI;
    }

}